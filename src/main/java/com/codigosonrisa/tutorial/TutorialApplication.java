package com.codigosonrisa.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	private static final Logger logger = LoggerFactory.getLogger(TutorialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		logger.debug("Mi Mensaje de Debug");
//		logger.info("Mi Mensaje de Info");
//		logger.warn("Mi Mensaje de Warn");
//		logger.error("Mi Mensaje de Error");
	}

}
