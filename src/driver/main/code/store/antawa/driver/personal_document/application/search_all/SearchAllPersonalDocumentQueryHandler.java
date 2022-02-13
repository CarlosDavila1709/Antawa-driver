package store.antawa.driver.personal_document.application.search_all;

import store.antawa.driver.personal_document.application.PersonalDocumentsResponse;
import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.bus.query.QueryHandler;

@Service
public class SearchAllPersonalDocumentQueryHandler implements QueryHandler<SearchAllPersonalDocumentQuery, PersonalDocumentsResponse>{

	 private final AllPersonalDocumentsSearcher searcher;
	 
	 public SearchAllPersonalDocumentQueryHandler(AllPersonalDocumentsSearcher searcher) {
		 
		 this.searcher = searcher;
	 }
	 

   @Override
   public PersonalDocumentsResponse handle(SearchAllPersonalDocumentQuery query) {
       return searcher.search();
   }
   
}
