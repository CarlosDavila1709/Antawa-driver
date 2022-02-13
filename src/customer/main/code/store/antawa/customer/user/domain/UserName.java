package store.antawa.customer.user.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UserName extends StringValueObject{

	public UserName(String value) {
		super(value);
	}

    public UserName() {
        super("");
    }
}
