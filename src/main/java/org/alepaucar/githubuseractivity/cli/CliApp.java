package org.alepaucar.githubuseractivity.cli;

import org.alepaucar.githubuseractivity.models.User;

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
        main();
    }
}
