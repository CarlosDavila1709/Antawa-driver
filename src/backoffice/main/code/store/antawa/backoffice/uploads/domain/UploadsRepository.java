package store.antawa.backoffice.uploads.domain;

import java.util.List;
import java.util.Optional;

import store.antawa.shared.domain.criteria.Criteria;

public interface UploadsRepository {

	void save(Uploads uploads);
	
	Optional<Uploads> search(UploadsUid uid);
	
	List<Uploads> matching(Criteria criteria);
	
    List<Uploads> searchAll();
    
}
