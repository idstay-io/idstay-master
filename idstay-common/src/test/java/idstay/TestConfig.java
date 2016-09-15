package idstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class TestConfig {
    public static void main(String[] args) {
        SpringApplication.run(TestConfig.class, args);
        System.out.println("io.idstay Web Application Started:");
    }
}