package store.antawa.driver.driver.application.find;

import store.antawa.shared.domain.bus.query.Query;

public final class FindDriverQuery implements Query{

    private final String uid;

    public FindDriverQuery(String uid) {
        this.uid = uid;
    }

    public String uid() {
        return uid;
    }
}
