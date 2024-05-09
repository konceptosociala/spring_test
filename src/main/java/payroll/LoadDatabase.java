package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import payroll.model.Employee;
import payroll.repository.EmployeeRepository;

@Configuration
class LoadDatabase {
    private static final Logger LOG = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            LOG.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            LOG.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}
