package org.alepaucar.githubuseractivity.cli;

import java.util.Scanner;

public class CliApp {
    private final Scanner scanner;

    public CliApp() {
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("----------------------------------------------------");
        System.out.println("-------------------TASK TRACKER---------------------");
    }
}
