package pl.com.git.info.receiver.gitinforeceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@ComponentScan("pl.com.git.info.receiver.gitinforeceiver")
public class GitinforeceiverApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(GitinforeceiverApplication.class, args);

        Thread.sleep(5000);
        ExecutorService executorService = Executors.newWorkStealingPool();
        long start = System.currentTimeMillis();
        List<Callable<String>> callables = Arrays.asList(
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class),
                () -> new RestTemplate().getForObject("http://localhost:8080/repositories/fisz0/AllegroTech", String.class));


        executorService.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        long finish = System.currentTimeMillis();
        System.out.println(finish - start);
        executorService.shutdown();
    }
}
