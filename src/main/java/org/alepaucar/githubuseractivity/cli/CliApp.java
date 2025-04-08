package org.alepaucar.githubuseractivity.cli;

import org.alepaucar.githubuseractivity.models.User;
import org.alepaucar.githubuseractivity.repositories.FetchData;

import java.util.Scanner;

import static org.alepaucar.githubuseractivity.models.User.main;

public class CliApp {
    private final Scanner scanner;

    public CliApp() {
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("----------------------------------------------------");
        System.out.println("-------------------TASK TRACKER---------------------");

        FetchData fetch = new FetchData("https://api.github.com/users/Ale-Paucar/events");



        System.out.println(fetch.getStatus());
        System.out.println(fetch.getMessage());
        System.out.println(fetch.getData());

    }
}
