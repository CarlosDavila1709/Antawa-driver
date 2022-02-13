package store.antawa.driver.driver.application.loguer;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.domain.DriverEmail;
import store.antawa.driver.driver.domain.DriverNotExist;
import store.antawa.driver.driver.domain.DriverPassword;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class LoguerDriverQueryHandler implements QueryHandler<LoguerDriverQuery, DriverResponse>{

	private final DriverLoguerIn seacher;

    public LoguerDriverQueryHandler(DriverLoguerIn seacher) {
        this.seacher = seacher;
    }

    @Override
    public DriverResponse handle(LoguerDriverQuery query) throws DriverNotExist {
 
    	return seacher.search(new DriverEmail(query.email()), new DriverPassword(query.password()));

    }
}
