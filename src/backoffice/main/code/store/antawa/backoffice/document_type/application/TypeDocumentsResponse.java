package store.antawa.backoffice.document_type.application;

import java.util.List;

import store.antawa.shared.domain.bus.query.Response;

public  class TypeDocumentsResponse implements Response{

	private final List<TypeDocumentResponse> types;
	
	public TypeDocumentsResponse(List<TypeDocumentResponse> types) {
		
		this.types = types;
	}
	
	public List<TypeDocumentResponse> types(){
		
		return types;
	
	}
}
