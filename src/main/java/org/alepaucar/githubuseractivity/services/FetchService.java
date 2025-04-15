package org.alepaucar.githubuseractivity.services;

import org.alepaucar.githubuseractivity.repositories.FetchData;

import java.util.List;

public class FetchService {

    private FetchData fetch;
    private String status;
    private String message;
    private String jsonData;

    public FetchService(String urlString) {
       this.fetch = new FetchData(urlString);
       this.status = fetch.getStatus();
       this.message = fetch.getMessage();
       this.jsonData = fetch.getData();
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getJsonData() {
        return jsonData;
    }
}
