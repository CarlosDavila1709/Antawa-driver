package store.antawa.shared.infrastructure.hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import store.antawa.shared.domain.Service;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public final class HibernateConfigurationFactory {
    private final ResourcePatternResolver resourceResolver;

    public HibernateConfigurationFactory(ResourcePatternResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    public PlatformTransactionManager hibernateTransactionManager(LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());

        return transactionManager;
    }

    public LocalSessionFactoryBean sessionFactory(String contextName, DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setHibernateProperties(hibernateProperties());
        /****solo de momento estara este codigo*****/
        List<Resource> mappingFiles = searchMappingFiles(contextName);
        if(mappingFiles.size()<1) {
        	mappingFiles = searchMappingFilesResources(contextName);
        }
        if(mappingFiles.size()<1){
        	try {
				throw new Exception("No se ha encontrado ningun hbm.xml...");
			} catch (Exception e) {
				System.out.println("no se ha mapeado el hbm "+ e.getMessage());
				e.printStackTrace();
			}
        }
        /****FIN*****/
        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

        return sessionFactory;
    }

    public DataSource dataSource(
        String host,
        Integer port,
        String databaseName,
        String username,
        String password
    ) throws IOException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(
            String.format(
                "jdbc:postgresql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                host,
                port,
                databaseName
            )
        );
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        Resource mysqlResource = resourceResolver.getResource(String.format(
            "classpath:database/%s.sql",
            databaseName
        ));
        String mysqlSentences = new Scanner(mysqlResource.getInputStream(), "UTF-8").useDelimiter("\\A").next();

        dataSource.setConnectionInitSqls(new ArrayList<>(Arrays.asList(mysqlSentences.split(";"))));

        return dataSource;
    }

    private List<Resource> searchMappingFiles(String contextName) {
        List<String> modules   = subdirectoriesFor(contextName);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private List<String> subdirectoriesFor(String contextName) {
        String path = "./src/" + contextName + "/main/code/store/antawa/" + contextName + "/";

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            path  = "./main/code/store/antawa/" + contextName + "/";
            files = new File(path).list((current, name) -> new File(current, name).isDirectory());
        }

        if (null == files) {
            return Collections.emptyList();
        }

        String finalPath = path;

        return Arrays.stream(files).map(file -> finalPath + file).collect(Collectors.toList());
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }
    /****solo de momento estara este codigo*****/
    private List<Resource> searchMappingFilesResources(String contextName){
		///administration/main/resources/administration/categorie/infrastructure/persistence/hibernate/Categorie.hbm.xml
		List<Resource>  listaBeans = new ArrayList<>();
    	try {
			Resource[] resources = resourceResolver.getResources("classpath:hbm_tmp/"+contextName+"/*.hbm.xml");
			for(Resource resou: resources) {
				listaBeans.add(resou);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaBeans;
	}
    /****FIN*****/
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "true");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        return hibernateProperties;
    }
}
