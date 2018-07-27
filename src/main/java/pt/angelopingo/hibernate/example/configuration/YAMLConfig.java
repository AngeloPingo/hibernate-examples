package pt.angelopingo.hibernate.example.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

    private String databaseUser;
    private String databasePassword;
    private String connectionUrl;
    private String driverClass;
    private String dialect;
    private boolean showSql;

}
