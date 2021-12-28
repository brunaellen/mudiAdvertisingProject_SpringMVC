package br.com.alura.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MudiAdvertisingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MudiAdvertisingApplication.class, args);
	}
}
