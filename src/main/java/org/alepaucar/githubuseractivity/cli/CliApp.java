package org.alepaucar.githubuseractivity.cli;

import org.alepaucar.githubuseractivity.models.Event;
import org.alepaucar.githubuseractivity.services.FetchService;
import org.alepaucar.githubuseractivity.services.ParseJsonService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CliApp {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";

    private final Scanner scanner;

    public CliApp() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("----------------------------------------------------");
        System.out.println("-------------------TASK TRACKER---------------------");

        while (true) {
            System.out.println("Please enter the github user name:");
            String input = scanner.nextLine().trim();
            String encodedUsername = URLEncoder.encode(input, StandardCharsets.UTF_8);
            FetchService data = new FetchService("https://api.github.com/users/" + encodedUsername + "/events");

            String status = data.getStatus();
            if (SUCCESS_STATUS.equals(status)) {
                processEvents(data);
            } else if (ERROR_STATUS.equals(status)) {
                System.out.println("Error: " + data.getMessage());
            } else {
                System.out.println("Something went wrong");
                return;
            }
        }
    }

    private void processEvents(FetchService data) {
        List<Event> recentEvents = ParseJsonService.parseJsonToEvents(data.getJsonData());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);

        for (Event e : recentEvents) {
            String output = generateOutput(e, formatter);
            System.out.println(output);
        }
    }

    private String generateOutput(Event e, DateTimeFormatter formatter) {
        String date = e.getDate().format(formatter);
        String repo = e.getRepoName();

        switch (e.getType()) {
            case "PushEvent":
                return String.format("- Pushed %d %s to \"%s\" on %s",
                        e.getCommitsSize(),
                        e.getCommitsSize() == 1 ? "commit" : "commits",
                        repo,
                        date);
            case "IssuesEvent":
                return String.format("- %s issue “%s” in \"%s\" on %s",
                        e.getAction(),
                        e.getIssueTitle(),
                        repo,
                        date);
            case "CreateEvent":
                return String.format("- Created new repository \"%s\" on %s", repo, date);
            default:
                return String.format("- %s in %s on %s", e.getType(), repo, date);
        }
    }
}
