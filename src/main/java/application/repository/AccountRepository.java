package application.repository;

import application.model.impl.AccountImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends
        JpaRepository<AccountImpl, Long> {
    @Query("SELECT a FROM AccountImpl a WHERE a.email = ?1 AND a.password = ?2")
    Optional<AccountImpl> findAccountByUserNamePassword(String email, String password);
}
