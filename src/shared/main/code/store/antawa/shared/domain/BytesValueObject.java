package store.antawa.shared.domain;

import java.util.Objects;

public abstract class BytesValueObject {
	private final byte [] value;

    public BytesValueObject(byte [] value) {
        this.value = value;
    }

    public byte [] value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringValueObject)) {
            return false;
        }
        BytesValueObject that = (BytesValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
