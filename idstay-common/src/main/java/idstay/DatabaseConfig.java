package idstay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;


import javax.sql.DataSource;

import static idstay.IdstayProfiles.*;

public abstract class DatabaseConfig {
//    public static final String DB_DRIVER_CLASS = "db.driver";
//    public static final String DB_URL = "db.url";
//    public static final String DB_USER = "db.username";
//    public static final String DB_PASSWORD = "db.password";
//
//    @Autowired
//    public Environment env;
//
//    @Bean
//    public abstract DataSource dataSource();
//
//    protected void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
//        dataSource.setMaxActive(10);
//        dataSource.setInitialSize(5);
//        dataSource.setMaxIdle(5);
//        dataSource.setMinIdle(1);
//
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTestOnBorrow(true);
//        dataSource.setValidationQuery("SELECT 1");
//
//        dataSource.setTimeBetweenEvictionRunsMillis(5000);
//        dataSource.setMinEvictableIdleTimeMillis(60000);
//    }
}

//@Configuration
//@Profile(DEVELOPMENT)
//class StandaloneDatabaseConfig extends DatabaseConfig {
//    public DataSource dataSource() {
//        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
//        dataSource.setDriverClassName(env.getProperty(DB_DRIVER_CLASS));
//        dataSource.setUrl(env.getProperty(DB_URL));
//        dataSource.setUsername(env.getProperty(DB_USER));
//        dataSource.setPassword(env.getProperty(DB_PASSWORD));
//        dataSource.setValidationQuery("SELECT 1");
//
//        configureDataSource(dataSource);
//        return dataSource;
//    }
//}
