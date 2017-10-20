package watsonApp;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.send.MessengerSendClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Created by jfink on 20/10/17.
 */

@SpringBootApplication
public class WatsonAppMain extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(WatsonAppMain.class, args);

    }

    @Bean
    public MessengerSendClient messengerSendClient(@Value("${messenger4j.pageAccessToken}") String pageAccessToken) {
        return MessengerPlatform.newSendClientBuilder(pageAccessToken).build();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WatsonAppMain.class);
    }
}
