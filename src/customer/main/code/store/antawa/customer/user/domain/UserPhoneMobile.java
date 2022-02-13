package store.antawa.customer.user.domain;

import store.antawa.shared.domain.StringValueObject;

public final class UserPhoneMobile extends StringValueObject{

	public UserPhoneMobile(String value) {
		super(value);
	}

    public UserPhoneMobile() {
        super("");
    }
}
