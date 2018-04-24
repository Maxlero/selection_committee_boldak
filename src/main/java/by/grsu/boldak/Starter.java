package by.grsu.boldak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring class. It will start the project
 */
@SpringBootApplication
public class Starter {
	/**
	 * Run Spring project
	 *
	 * @param args Arguments to pass from execution promt to Spring
	 */
	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
