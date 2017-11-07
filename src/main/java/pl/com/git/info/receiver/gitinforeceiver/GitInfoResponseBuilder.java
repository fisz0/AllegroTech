package pl.com.git.info.receiver.gitinforeceiver;

public class GitInfoResponseBuilder {
    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stargazers;
    private String creationDate;

    public GitInfoResponseBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public GitInfoResponseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public GitInfoResponseBuilder setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
        return this;
    }

    public GitInfoResponseBuilder setStargazers(Integer stargazers) {
        this.stargazers = stargazers;
        return this;
    }

    public GitInfoResponseBuilder setCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public GitInfoResponse createGitInfoResponse() {
        return new GitInfoResponse(fullName, description, cloneUrl, stargazers, creationDate);
    }
}