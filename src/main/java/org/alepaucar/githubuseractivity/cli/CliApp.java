package org.alepaucar.githubuseractivity.cli;


import org.alepaucar.githubuseractivity.repositories.FetchData;
import org.alepaucar.githubuseractivity.services.FetchService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;



public class CliApp {
    private final Scanner scanner;

    public CliApp() {
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("----------------------------------------------------");
        System.out.println("-------------------TASK TRACKER---------------------");
        while (true){
            System.out.println("Please enter the github user name:");
            String input = scanner.nextLine().trim();
            String encodedUsername = URLEncoder.encode(input, StandardCharsets.UTF_8);
            FetchService data = new FetchService("https://api.github.com/users/"+encodedUsername+"/events");

            if(data.getStatus().equals("success")){

            }else if(data.getStatus().equals("error")){
                System.out.println("Error: "+data.getMessage());
            }else{
                System.out.println("Something went wrong");
                return;
            }

            System.out.println(data.getJsonData());
        }


    }
}
