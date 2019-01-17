package at.nightfight.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class NightFightApplication {
	public static void main(String[] args) {
		SpringApplication.run(NightFightApplication.class, args);
	}	
}