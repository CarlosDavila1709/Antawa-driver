package store.antawa.driver.personal_document.application;

import store.antawa.driver.personal_document.domain.PersonalDocument;
import store.antawa.shared.domain.bus.query.Response;

public final  class PersonalDocumentResponse implements Response{

	private final String uid;
	private final String name;
	
	public PersonalDocumentResponse(String uid, String name) {
		
		this.uid 	= uid;
		this.name 	= name;
	}
	
	public static PersonalDocumentResponse fromAggregate(PersonalDocument personalDocument) {
		
		return new PersonalDocumentResponse(personalDocument.uid().value(), 
											personalDocument.name().value());
		
	}
	
	public String uid() {
		return uid;
	}
	public String name() {
		return name;
	}
}
