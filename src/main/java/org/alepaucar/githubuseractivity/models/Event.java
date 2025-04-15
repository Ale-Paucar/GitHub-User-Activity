package org.alepaucar.githubuseractivity.models;

public class Event {
    private String type;
    private int repoID;
    private String repoName;
    private int commitsSize;
    private String action;
    private String issueTitle;
    private String description;

    public Event(String type, int repoID, String repoName, int commitsSize, String action, String issueTitle, String description) {
        this.type = type;
        this.repoID = repoID;
        this.repoName = repoName;
        this.commitsSize = commitsSize;
        this.action = action;
        this.issueTitle = issueTitle;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRepoID() {
        return repoID;
    }

    public void setRepoID(int repoID) {
        this.repoID = repoID;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public int getCommitsSize() {
        return commitsSize;
    }

    public void setCommitsSize(int commitsSize) {
        this.commitsSize = commitsSize;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }
}
