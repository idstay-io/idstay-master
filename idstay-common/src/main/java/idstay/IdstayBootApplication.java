package idstay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import static java.lang.String.format;

public class IdstayBootApplication extends SpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(IdstayBootApplication.class);
    public IdstayBootApplication(Class<?> configClass) {
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
