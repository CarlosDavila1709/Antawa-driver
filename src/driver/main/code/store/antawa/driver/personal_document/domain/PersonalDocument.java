package store.antawa.driver.personal_document.domain;

import java.util.Objects;

public abstract class PersonalDocument{

	private final PersonalDocumentUid uid;
	
	private final PersonalDocumentName name;
	
	
	public PersonalDocument(PersonalDocumentUid uid, PersonalDocumentName name) {
		
		this.uid = uid;
		this.name = name;
	}

	public PersonalDocumentUid uid() {
		return uid;
	}
	
	public PersonalDocumentName name() {
		return name;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonalDocument personalDocument = (PersonalDocument) o;
        return uid.equals(personalDocument.uid) &&
               name.equals(personalDocument.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash( uid, name);
    }
}
