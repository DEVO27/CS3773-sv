package application.config;

import application.model.impl.AccountImpl;
import application.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {
    /**
     *     public AccountImpl(String name, String userName, String password) {
     *         super(name, userName, password);
     *         this.iD = generateId();
     *     }
     */
    
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            AccountImpl austen = new AccountImpl(
                    "Austen",
                    "Austen782",
                    "Ideeli23"

            );

            AccountImpl cynthia = new AccountImpl(
                    "cynthia",
                    "cynthia4570",
                    "austen86"
            );

            repository.saveAll(List.of(austen, cynthia));
        };
    }
}
