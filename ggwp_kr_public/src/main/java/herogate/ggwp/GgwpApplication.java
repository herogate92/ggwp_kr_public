package herogate.ggwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GgwpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GgwpApplication.class, args);
	}
}
