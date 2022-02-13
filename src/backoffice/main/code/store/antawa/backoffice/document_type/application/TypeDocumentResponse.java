package store.antawa.backoffice.document_type.application;

import store.antawa.backoffice.document_type.domain.DocumentType;
import store.antawa.shared.domain.bus.query.Response;

public final class TypeDocumentResponse implements Response{

	private final String uid;
	
	private final String name;
	
	private final String codigo;
	
	public TypeDocumentResponse(String uid, String name, String codigo) {
		this.uid  	= uid;
		this.name 	= name;
		this.codigo = codigo;
	}
	
	public static TypeDocumentResponse fromAggregate(DocumentType document) {
		
		return new TypeDocumentResponse(
				document.uid().value(),
				document.name().value(),
				document.codigo().value());
				
	}
	
	public String uid() {
		return uid;
	}
	
	public String name() {
		return name;
	}
	
	public String codigo() {
		return codigo;
	}
	
}
