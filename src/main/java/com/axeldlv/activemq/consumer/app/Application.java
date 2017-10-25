package com.axeldlv.activemq.consumer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.axeldlv.activemq.consumer.app.service.MessageServiceImpl;

@SpringBootApplication
@ComponentScan({"com.axeldlv.activemq.app"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public MessageServiceImpl messageService() {
        return new MessageServiceImpl();
    }

}
