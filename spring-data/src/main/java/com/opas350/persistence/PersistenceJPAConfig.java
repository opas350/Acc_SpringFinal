package com.opas350.persistence;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by javier.reyes.valdez on 3/2/2017.
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.opas350.entities")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages="com.opas350.repository")
@ComponentScan({"com.opas350.entities"})
public class PersistenceJPAConfig {

    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    protected static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println("---- ENTER ENTITYMANAGERFACTORY");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"com.opas350.entities"});
        System.out.println("---- BEFORE JpaVendorAdapter");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        System.out.println("---- AFTER JpaVendorAdapter");
        em.setJpaVendorAdapter(vendorAdapter);
        System.out.println("---- AFTER SET JpaVendorAdapter");
        em.setJpaProperties(additionalProperties());
        System.out.println("---- AFTER PROPERTIES JpaVendorAdapter");

        System.out.println("----EXIT ENTITYMANAGERFACTORY");

        return em;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        System.out.println("------ ENTER DATASOURCE ----------");
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        System.out.println("------ EXIT DATASOURCE -------");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        System.out.println("------- ENTER TRANSACTION MANAGER ----------");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        System.out.println("------- EXIT TRANSACTION MANAGER ----------");

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        System.out.println("------------ EXCEPTION TRANSLATION -------------");
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        System.out.println("-------- ENTER ADDITIONAL PROPERTIES ---------");
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        System.out.println("-------------- EXIT ADDITIONAL PROPERTIES ----------");
        return properties;
    }
}
