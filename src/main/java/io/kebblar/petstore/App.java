package io.kebblar.petstore;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("io.kebblar.petstore.api.mapper")
@SpringBootApplication
@EnableScheduling
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("Iniciando contexto de Spring, by Goose");
        SpringApplication.run(App.class, args);
    }
}