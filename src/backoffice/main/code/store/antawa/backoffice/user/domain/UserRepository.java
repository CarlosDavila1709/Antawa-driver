package store.antawa.backoffice.user.domain;

import java.util.List;
import java.util.Optional;
import store.antawa.shared.domain.criteria.Criteria;

public interface UserRepository {

	void save(User user);
	
	Optional<User> search(UserUid uid);
	
	List<User> matching(Criteria criteria);
	
    List<User> searchAll();
}
