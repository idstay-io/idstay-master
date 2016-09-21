package idstay;

import idstay.housekeeping.HousekeepingController;
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
import static idstay.IdstayProfiles.*;

public class IdstaySpringApplication extends SpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(IdstaySpringApplication.class);
    public IdstaySpringApplication(Class<?> configClass) {
        super(configClass);
    }

    @Override
    protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {
        super.configureProfiles(environment, args);

        boolean developmentActive = environment.acceptsProfiles(DEVELOPMENT);
        boolean stagingActive = environment.acceptsProfiles(STAGING);
        boolean productionActive = environment.acceptsProfiles(PRODUCTION);




        if (developmentActive && stagingActive && productionActive) {
            throw new IllegalStateException(format("Only one of the following profiles may be specified: [%s]",
                    arrayToCommaDelimitedString(new String[] { DEVELOPMENT, STAGING, PRODUCTION })));
        } else {
        }

        if (stagingActive || productionActive) {

            environment.addActiveProfile(PRODUCTION);
        }
        else {
            System.out.println("The default 'standalone' profile is active because no other profiles have been specified.");
            logger.info("[{}] profile is activated", productionActive);
        }

    }
}
