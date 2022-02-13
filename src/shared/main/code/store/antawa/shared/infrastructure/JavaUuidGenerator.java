package store.antawa.shared.infrastructure;

import store.antawa.shared.domain.Service;
import store.antawa.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
