package watsonApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by jfink on 20/10/17.
 */

@SpringBootApplication
public class WatsonAppMain extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(WatsonAppMain.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WatsonAppMain.class);
    }
}
