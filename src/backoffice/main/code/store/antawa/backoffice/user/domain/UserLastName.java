package store.antawa.backoffice.user.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UserLastName  extends StringValueObject{


	public UserLastName(String value) {
		super(value);
	}

    public UserLastName() {
        super("");
    }
}
