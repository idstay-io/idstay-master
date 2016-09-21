package idstay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

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

    protected void h2Config(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:idstay;MODE=MySQL");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setValidationQuery("SELECT 1");
    }

    protected void mysqlConfig(org.apache.tomcat.jdbc.pool.DataSource dataSource) {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/idstay");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setValidationQuery("SELECT 1");
    }
}

@Configuration
@Profile(IdstayProfiles.DEVELOPMENT)
class StandaloneDatabaseConfig extends DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        h2Config(dataSource);
        configureDataSource(dataSource);
        return dataSource;
    }
}

@Configuration
@Profile(IdstayProfiles.PRODUCTION)
class ProductionDatabaseConfig extends DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        mysqlConfig(dataSource);
        configureDataSource(dataSource);
        return dataSource;
    }
}



