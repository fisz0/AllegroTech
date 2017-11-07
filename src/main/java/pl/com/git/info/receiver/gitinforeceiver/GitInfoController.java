package pl.com.git.info.receiver.gitinforeceiver;


import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

@RestController
public class GitInfoController {


    @GetMapping("/repositories/{username}/{repository_name}")
    public GitInfoResponse getRepository(@PathVariable("username") String username, @PathVariable("repository_name") String repositoryName) throws IOException {
        GHRepository repository = new GitHubBuilder().withProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("tmg.tvp.pl", 80))).build().getUser(username).getRepository(repositoryName);
        GitInfoResponse response = GitInfoConverter.convert(repository);
        return response;
    }
}