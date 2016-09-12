package idstay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class IdstayApplication {
    public static void main(String[] args) {
        SpringApplication.run(IdstayApplication.class, args);
        System.out.println("io.idstay Web Application Started:");
    }
}
