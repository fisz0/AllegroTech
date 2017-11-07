package pl.com.git.info.receiver.gitinforeceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.com.git.info.receiver.gitinforeceiver")
public class GitinforeceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitinforeceiverApplication.class, args);
	}
}
