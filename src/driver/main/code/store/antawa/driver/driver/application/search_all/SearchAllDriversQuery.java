package store.antawa.driver.driver.application.search_all;

import java.util.Objects;

import store.antawa.shared.domain.bus.query.Query;

public final class SearchAllDriversQuery implements Query {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("SearchAllDriversQuery");
    }
}
