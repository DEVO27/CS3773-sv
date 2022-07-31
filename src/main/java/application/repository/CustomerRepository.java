package application.repository;

import application.model.impl.CustomerImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends
        JpaRepository<CustomerImpl, Long> {

}
