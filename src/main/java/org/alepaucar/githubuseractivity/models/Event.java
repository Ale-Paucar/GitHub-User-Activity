package org.alepaucar.githubuseractivity.models;

import java.time.LocalDateTime;

public class Event {
    private String type;
    private int repoID;
    private String repoName;
    private int commitsSize;
    private String action;
    private String issueTitle;
    private String description;
    private LocalDateTime date;

    public Event(String type, int repoID, String repoName, int commitsSize, String action, String issueTitle, String description, LocalDateTime date) {
        this.type = type;
        this.repoID = repoID;
        this.repoName = repoName;
        this.commitsSize = commitsSize;
        this.action = action;
        this.issueTitle = issueTitle;
        this.description = description;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public int getRepoID() {
        return repoID;
    }

    public String getRepoName() {
        return repoName;
    }

    public int getCommitsSize() {
        return commitsSize;
    }

    public String getAction() {
        return action;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
