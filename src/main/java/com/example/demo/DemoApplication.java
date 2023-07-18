package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(DemoApplication.class);
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		run.getBeanDefinitionNames();
		logger.trace("Маршрут выполнения программы");
		logger.debug("Отладочное сообщение");
		logger.info("Информационное сообщение");
		logger.warn("Предупреждение");
		logger.error("Сообщение об ошибке");
	}

}
