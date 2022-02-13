package store.antawa.driver.driver.application.search_all;

import store.antawa.driver.driver.application.DriversResponse;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllDriversQueryHandler implements QueryHandler<SearchAllDriversQuery, DriversResponse>{

	 private final AllDriversSearcher searcher;
	 
	 public SearchAllDriversQueryHandler(AllDriversSearcher searcher) {
		 
		 this.searcher = searcher;
	 }
	 

    @Override
    public DriversResponse handle(SearchAllDriversQuery query) {
        return searcher.search();
    }
}
