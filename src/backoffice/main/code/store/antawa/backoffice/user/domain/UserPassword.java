package store.antawa.backoffice.user.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UserPassword  extends StringValueObject{

	public UserPassword(String value) {
		super(value);
	}

    public UserPassword() {
        super("");
    }
}
