package idstay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import static java.lang.String.format;
import static org.springframework.util.StringUtils.arrayToCommaDelimitedString;
import static idstay.appconfig.IdstayProfiles.*;

public class IdstaySpringApplication extends SpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(IdstaySpringApplication.class);
    public IdstaySpringApplication(Class<?> configClass) {
        super(configClass);
    }

    @Override
    protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {
        super.configureProfiles(environment, args);

        boolean stagingActive = environment.acceptsProfiles(STAGING);
        boolean productionActive = environment.acceptsProfiles(PRODUCTION);

        if (stagingActive && productionActive) {
            throw new IllegalStateException(format("Only one of the following profiles may be specified: [%s]",
                    arrayToCommaDelimitedString(new String[] { STAGING, PRODUCTION })));
        }

        if (productionActive) {
            printActiveProfile(PRODUCTION);
            environment.addActiveProfile(PRODUCTION);
        } else if(stagingActive){
            printActiveProfile(STAGING);
            environment.addActiveProfile(STAGING);
        } else {
            printActiveProfile(STANDALONE);
            environment.addActiveProfile(STANDALONE);
        }
    }

    private void printActiveProfile(String profile) {
        System.out.println("====================================");
        System.out.println("The '" + profile.toString() + "' profile is active.");
        System.out.println("====================================");
    }
}
