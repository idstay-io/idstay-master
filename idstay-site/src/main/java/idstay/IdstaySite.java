package idstay;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SocialWebAutoConfiguration.class)
@EntityScan
@EnableJpaRepositories
@EnableCaching
public class IdstaySite {
    public static void main(String[] args) {
        new IdstayBootApplication(IdstaySite.class).run(args);
    }


}
