package store.antawa.backoffice.user.application.loguer;

import store.antawa.backoffice.user.UserResponse;
import store.antawa.backoffice.user.domain.UserEmail;
import store.antawa.backoffice.user.domain.UserNotExist;
import store.antawa.backoffice.user.domain.UserPassword;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class LoguerUserBackofficeQueryHandler implements QueryHandler<LoguerUserBackofficeQuery, UserResponse>  {

	private final UserBackofficeLoguerIn seacher;
	
    public LoguerUserBackofficeQueryHandler(UserBackofficeLoguerIn seacher) {
        this.seacher = seacher;
    }

    @Override
    public UserResponse handle(LoguerUserBackofficeQuery query) throws UserNotExist {
 
    	return seacher.search(new UserEmail(query.email()), new UserPassword(query.password()));

    }
}
