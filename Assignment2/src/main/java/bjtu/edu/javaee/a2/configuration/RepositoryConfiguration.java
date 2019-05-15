package bjtu.edu.javaee.a2.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"bjtu.edu.javaee.a2.domain"})
@EnableJpaRepositories(basePackages = {"bjtu.edu.javaee.a2.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
