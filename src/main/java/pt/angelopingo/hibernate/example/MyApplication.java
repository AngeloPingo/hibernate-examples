package pt.angelopingo.hibernate.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.angelopingo.hibernate.example.configuration.YAMLConfig;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApplication.class);
        app.run();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
    }

}
