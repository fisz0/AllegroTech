package pl.com.git.info.receiver.gitinforeceiver;

import lombok.Data;

@Data
public class GitInfoResponse {
    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stargazers;
    private String creationDate;

    public GitInfoResponse(String fullName, String description, String cloneUrl, Integer stargazers, String creationDate) {
        this.fullName = fullName;
        this.description = description;
        this.cloneUrl = cloneUrl;
        this.stargazers = stargazers;
        this.creationDate = creationDate;
    }
}
