package org.alepaucar.githubuseractivity.repositories;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchData {
    private String status;
    private String data;
    private String message;

    public FetchData(String githubEndpoint) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(githubEndpoint))
                .build();
        try {
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );
            int code = response.statusCode();
            if(code == 200){
                this.status="success";
                this.data = response.body();
            }else{
                this.status="error";
                this.message=getErrorMessage(code);
            }
        } catch (IOException | InterruptedException e) {
            this.status = "error";
            this.message = "Exception processing request: " + e.getMessage();
            e.printStackTrace();
        }
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }


    private String getErrorMessage(int code) {
        return switch (code) {
            case 404 -> "User not found";
            case 403 -> "Request limit reached";
            case 401 -> "Invalid or unauthorized token";
            default -> "Unexpected error: " + code;
        };
    }
}
