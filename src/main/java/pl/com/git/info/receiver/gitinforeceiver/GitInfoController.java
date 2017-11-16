package pl.com.git.info.receiver.gitinforeceiver;


import org.kohsuke.github.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.Callable;

@RestController
public class GitInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitInfoController.class);

    private static GitHub gitHub;

    @PostConstruct
    public static void init() {
        try {
            gitHub = new GitHubBuilder().withProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("tmg.tvp.pl", 80))).withPassword("fisz0", "182marcin82").build();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @GetMapping("/repositories/{username}/{repository_name}")
    public Callable<ResponseEntity<?>> getRepository(@PathVariable("username") String userName, @PathVariable("repository_name") String repositoryName) throws IOException {
        Callable<ResponseEntity<?>> responseEntity = () -> {

            GHUser user = null;
            try {
                user = gitHub.getUser(userName);
            } catch (GHFileNotFoundException e) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            GHRepository repository = user.getRepository(repositoryName);
            if (repository != null) {
                GitInfoResponse response = GitInfoConverter.convert(repository);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Repository not found", HttpStatus.NOT_FOUND);
            }
        };
        return responseEntity;
    }
}

