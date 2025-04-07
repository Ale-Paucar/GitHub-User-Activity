package org.alepaucar.githubuseractivity.models;

import com.google.gson.Gson;

public class User {
    private String login;
    private String id;
    private String avatarUrl;
    private String htmlUrl;
    private int followers;
    private int following;

    public static void gsonPorrofSuser() {
        // JSON de ejemplo, puede ser más simple o complejo
        String json = "{\"login\":\"octocat\",\"id\":\"1\",\"followers\":500}";

        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Convertir el JSON a un objeto Java (User)
        User user = gson.fromJson(json, User.class);

        // Convertir el objeto Java de nuevo a JSON (solo para mostrar)
        String jsonOutput = gson.toJson(user);

        // Imprimir el JSON original y el nuevo JSON generado
        System.out.println("JSON original: " + json);
        System.out.println("JSON generado desde el objeto: " + jsonOutput);
    }

    public static void main() {
        gsonPorrofSuser();
    }
}
