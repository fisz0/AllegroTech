package pl.com.git.info.receiver.gitinforeceiver;

import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class GitInfoConverter {

    public static GitInfoResponse convert(GHRepository repository) throws IOException {
        return new GitInfoResponseBuilder().
                setFullName(repository.getFullName()).
                setDescription(repository.getDescription()).
                setCloneUrl(repository.getUrl().getPath()).
                setCreationDate(convertFormatedDate(repository)).
                setStargazers(repository.getStargazersCount()).
                createGitInfoResponse();
    }

    private static String convertFormatedDate(GHRepository repository) throws IOException {
        return LocalDateTime.ofInstant(repository.getCreatedAt().toInstant(), ZoneId.systemDefault()).format(DateTimeFormatter.ISO_DATE_TIME).toString();
    }

}
