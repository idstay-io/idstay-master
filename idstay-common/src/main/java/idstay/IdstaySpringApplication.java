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
import static idstay.IdstayProfiles.*;

public class IdstaySpringApplication extends SpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(IdstaySpringApplication.class);
    public IdstaySpringApplication(Class<?> configClass) {
        super(configClass);
    }

    private String getProfile(String[] activeProfiles) {
        String activeProfile;
        switch (activeProfiles[0]) {
            case "development" :
                activeProfile = IdstayProfiles.DEVELOPMENT;
                break;
            default:
                activeProfile = IdstayProfiles.DEVELOPMENT;
                break;

        }
        return activeProfile;
    }


    @Override
    protected void configureProfiles(ConfigurableEnvironment environment, String[] args) {
        super.configureProfiles(environment, args);
//
//        String[] str = environment.getActiveProfiles();
//
//        System.out.println("============" + str[0]);
//
//
//        boolean stagingActive = environment.acceptsProfiles(STAGING);
//        boolean productionActive = environment.acceptsProfiles(PRODUCTION);
//
//        if (stagingActive && productionActive) {
//            throw new IllegalStateException(format("Only one of the following profiles may be specified: [%s]",
//                    arrayToCommaDelimitedString(new String[] { STAGING, PRODUCTION })));
//        }
//
//        environment.addActiveProfile(getProfile(environment.getActiveProfiles()));
//        printActiveProfile(environment.get);

//        if (productionActive) {
//            printActiveProfile(PRODUCTION);
//            environment.addActiveProfile(PRODUCTION);
//        } else if(stagingActive){
//            printActiveProfile(STAGING);
//            environment.addActiveProfile(STAGING);
//        } else {
//            printActiveProfile(STANDALONE);
//            environment.addActiveProfile(STANDALONE);
//        }
    }

    private void printActiveProfile(String profile) {
        System.out.println("====================================");
        System.out.println("The '" + profile.toString() + "' profile is active.");
        System.out.println("====================================");
    }
}
