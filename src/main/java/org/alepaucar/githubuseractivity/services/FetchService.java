package org.alepaucar.githubuseractivity.services;

import org.alepaucar.githubuseractivity.repositories.FetchData;

import java.util.List;

public class FetchService {

    private List<T> data;
    private String errorMessage;

    public FetchService(String urlString) {
        FetchData fetch = new FetchData(urlString);
        if(fetch.getStatus().equals("success")){
            //parseamos json con gson y lo almacenamos en data
        }
        if(fetch.getStatus().equals("error")){
            //Terminamos el programa o sino volvemos al comienzo
        }
    }
}
