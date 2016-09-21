package idstay;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SocialWebAutoConfiguration.class)
@EntityScan
@EnableJpaRepositories
public class IdstaySite {
    public static void main(String[] args) {
        new IdstaySpringApplication(IdstaySite.class).run(args);
//        SpringApplication.run(IdstaySite.class);
        System.out.println("io.idstay Web Application Started:");
    }

    @Bean
    //@Profile(IdstayProfiles.STANDALONE)
    public ServletRegistrationBean h2Console() {
        System.out.println(".........................");
        ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet(), "/console/*");
        reg.setLoadOnStartup(1);
        return reg;
    }
}