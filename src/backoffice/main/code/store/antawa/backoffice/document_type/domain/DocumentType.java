package store.antawa.backoffice.document_type.domain;

import java.util.Objects;

import store.antawa.shared.domain.AggregateRoot;

public final class DocumentType extends AggregateRoot{

	private final DocumentTypeUid uid;
	
	private final DocumentName name;
	
	private final DocumentCodigo codigo;
	
	
	public DocumentType(DocumentTypeUid uid, DocumentName name, DocumentCodigo codigo) {
		
		this.uid 	= uid;
		this.name 	= name;
		this.codigo = codigo;
	}
	
	public DocumentType() {
		
		this.uid 	= null;
		this.name 	= null;
		this.codigo = null;
		
	}
	
	public static DocumentType create(DocumentTypeUid uid, DocumentName name, DocumentCodigo codigo) {
		
		DocumentType documentType =  new DocumentType(uid, name, codigo);
		
		return documentType;
	}
	
    public DocumentTypeUid uid() {
    	return uid;
    }
    
    public DocumentName name() {
    	return name;
    }
    
    public DocumentCodigo codigo() {
    	return codigo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DocumentType documentType = (DocumentType) o;
        return uid.equals(documentType.uid) &&
               name.equals(documentType.name) &&
               codigo.equals(documentType.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash( uid,
        		 name,
        		 codigo);
    }
}
