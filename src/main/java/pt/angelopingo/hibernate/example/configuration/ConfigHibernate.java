package pt.angelopingo.hibernate.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pt.angelopingo.hibernate.example.model.NetworkElement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("pt.angelopingo.hibernate.example.dao"),
        @ComponentScan("pt.angelopingo.hibernate.example.service") })
public class ConfigHibernate {

    @Autowired
    private YAMLConfig myConfig;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        // Setting JDBC properties
        props.put(USER, myConfig.getDatabaseUser());
        props.put(PASS, myConfig.getDatabasePassword());
        props.put(DRIVER, myConfig.getDriverClass());
        props.put(URL, myConfig.getConnectionUrl());

        // Setting Hibernate properties
        props.put(SHOW_SQL, myConfig.isShowSql());

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(NetworkElement.class);

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
