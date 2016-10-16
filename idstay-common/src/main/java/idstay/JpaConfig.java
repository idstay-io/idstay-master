package idstay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

import static idstay.IdstayProfiles.*;


public abstract class JpaConfig {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(this.dataSource);
//        em.setPackagesToScan(new String[] { "idstay" });
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        em.setJpaProperties(additionalProperties());
//
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    abstract Properties additionalProperties();
}

//@Configuration
//@EnableTransactionManagement
//@Profile({STAGING, PRODUCTION})
//class ProductionConfig extends JpaConfig{
//
//    public Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.ebj.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
//        return properties;
//    }
//}

//@Configuration
//@EnableTransactionManagement
//@Profile({DEVELOPMENT})
//class StandaloneConfig extends JpaConfig{
//    public Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("hibernate.implicit_naming_strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl");
//        properties.setProperty("hibernate.physical_naming_strategy", "fms.util.hibernate.ImprovedNamingStrategy");
//        return properties;
//    }
//}