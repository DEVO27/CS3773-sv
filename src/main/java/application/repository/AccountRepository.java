package application.repository;

import application.model.impl.AccountImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AccountRepository extends JpaRepository<AccountImpl, UUID> {

}
