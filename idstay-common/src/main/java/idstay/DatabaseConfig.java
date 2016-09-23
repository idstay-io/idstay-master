package idstay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import javax.sql.DataSource;

import static idstay.IdstayProfiles.*;

public abstract class DatabaseConfig {

    @Bean
    public abstract DataSource dataSource();

    protected void configureDataSource(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setMaxActive(20);
        dataSource.setMaxIdle(8);
        dataSource.setMinIdle(8);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
    }

    protected void mysqlConfig(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/idstay");
        dataSource.setUsername("idstay_db_user");
        dataSource.setPassword("_p@ssword_of_db_user_");
        dataSource.setValidationQuery("SELECT 1");
    }

    protected void developmentConfig(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/idstay2");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setValidationQuery("SELECT 1");
    }



}

@Configuration
@Profile({STANDALONE})
class StandaloneDatabaseConfig extends DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        developmentConfig(dataSource);
        configureDataSource(dataSource);
        return dataSource;
    }
}

@Configuration
@Profile(PRODUCTION)
class ProductionDatabaseConfig extends DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        mysqlConfig(dataSource);
        configureDataSource(dataSource);
        return dataSource;
    }
}



