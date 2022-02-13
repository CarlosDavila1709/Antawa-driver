package store.antawa.backoffice.uploads.infrastructure.persistence;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import store.antawa.backoffice.document_type.domain.DocumentTypeUid;
import store.antawa.backoffice.uploads.domain.FileSystemRepository;
import store.antawa.backoffice.uploads.domain.Uploads;
import store.antawa.backoffice.uploads.domain.UploadsFile;
import store.antawa.backoffice.uploads.domain.UploadsName;
import store.antawa.backoffice.uploads.domain.UploadsPath;

import store.antawa.shared.domain.Service;
import store.antawa.shared.infrastructure.config.Parameter;
import store.antawa.shared.infrastructure.config.ParameterNotExist;

@Service
public final class InFileSystemUploadsRepository implements FileSystemRepository{

	private Parameter config;
	private Path fileStorageLocation;

	
	public InFileSystemUploadsRepository(Parameter config) {

		this.config = config;

		try {

			this.fileStorageLocation = Paths.get(config.get("UPLOADS_DOCUMENTS_DRIVER_DOCUMENTS")).toAbsolutePath()
					.normalize();

			System.out.println("1 - fileStorageLocation " + fileStorageLocation.toString());

			Files.createDirectories(this.fileStorageLocation);

		} catch (ParameterNotExist e) {

			e.printStackTrace();

		} catch (Exception ex) {

		}
	}

	@Override
	public void save(Uploads uploads) {

		try {

			InputStream inputStream = new ByteArrayInputStream(uploads.file().value());

			Path targetLocation = fileStorageLocation.resolve(uploads.path().value());

			System.out.println("fileStorageLocation " + targetLocation.toString());

			Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);

		
		} catch (IOException ex) {

			ex.printStackTrace();

		}
	}

	@Override
	public Optional<Uploads> search(UploadsName name) {

		UploadsName _name 			= null;
		DocumentTypeUid typeUid 	= null;
		UploadsFile uploadsFile 	= null;
		UploadsPath uploadsPath 	= null;

		String pathFile = "";
		
		try {
			pathFile = config.get("UPLOADS_DOCUMENTS_DRIVER_DOCUMENTS") + "/" +name.value();
			
			File file = new File(pathFile);
	
			if( file.isFile() == false ) {
				
				return Optional.of(null);
			
			}
			
			long byteLength = file.length(); // byte count of the file-content
	
			byte[] filecontent = new byte[(int) byteLength];
			
			//fileInputStream.read(filecontent, 0, (int) byteLength);
		
			_name   	 = new UploadsName(name.value());
			typeUid 	 = new DocumentTypeUid();
			uploadsFile  = new UploadsFile(filecontent);
			uploadsPath  = new UploadsPath(pathFile);
			
			
		}catch (ParameterNotExist e) {

			e.printStackTrace();

		} 

		return  Optional.of(new Uploads(null, null, uploadsFile, uploadsPath, _name));

	}


}
