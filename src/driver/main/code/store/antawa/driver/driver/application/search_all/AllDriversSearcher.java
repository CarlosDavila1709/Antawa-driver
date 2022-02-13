package store.antawa.driver.driver.application.search_all;

import java.util.stream.Collectors;

import store.antawa.driver.driver.application.DriverResponse;
import store.antawa.driver.driver.application.DriversResponse;
import store.antawa.driver.driver.domain.DriverRepository;
import store.antawa.shared.domain.Service;

@Service
public final class AllDriversSearcher {

    private final DriverRepository repository;

    public AllDriversSearcher(DriverRepository repository) {
        this.repository = repository;
    }

    public DriversResponse search() {
        return new DriversResponse(
            repository.searchAll().stream().map(DriverResponse::fromAggregate).collect(Collectors.toList())
        );
    }
    
}
