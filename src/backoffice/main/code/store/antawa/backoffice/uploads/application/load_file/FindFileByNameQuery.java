package store.antawa.backoffice.uploads.application.load_file;

import store.antawa.shared.domain.bus.query.Query;

public final class FindFileByNameQuery implements Query{

	 private final String name;
	 
	 
	 public FindFileByNameQuery(String name) {
		 
		 this.name = name;
		 
	 }
	 
	 public String name() {
		 
		 return name;
	 }
}
