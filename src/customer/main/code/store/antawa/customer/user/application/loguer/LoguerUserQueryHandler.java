package store.antawa.customer.user.application.loguer;

import store.antawa.customer.user.application.UserResponse;
import store.antawa.customer.user.domain.UserEmail;
import store.antawa.customer.user.domain.UserNotExist;
import store.antawa.customer.user.domain.UserPassword;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class LoguerUserQueryHandler implements QueryHandler<LoguerUserQuery, UserResponse>  {
	
	private final UserLoguerIn seacher;

    public LoguerUserQueryHandler(UserLoguerIn seacher) {
        this.seacher = seacher;
    }

    @Override
    public UserResponse handle(LoguerUserQuery query) throws UserNotExist {
 
    	return seacher.search(new UserEmail(query.email()), new UserPassword(query.password()));

    }

}
