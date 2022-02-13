package store.antawa.customer.user.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UserEmail extends StringValueObject{

	public UserEmail(String value) {
		super(value);
	}

    public UserEmail() {
        super("");
    }
}
