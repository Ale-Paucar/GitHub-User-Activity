package org.alepaucar.githubuseractivity.models;

import com.google.gson.Gson;

public class User {
    private String login;
    private String id;
    private String avatarUrl;
    private String htmlUrl;
    private int followers;
    private int following;

    public User(String login, String id, String avatarUrl, String htmlUrl, int followers, int following) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
        this.followers = followers;
        this.following = following;
    }

    public static void gsonPorrofSuser() {
        // JSON de ejemplo, puede ser más simple o complejo


        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Convertir el JSON a un objeto Java (User)
        User user = new User("ale","asdas13121312","asdaURL","jtmlsadaURL",12,2131);

        // Convertir el objeto Java de nuevo a JSON (solo para mostrar)
        String jsonOutput = gson.toJson(user);

        // Imprimir el JSON original y el nuevo JSON generado

        System.out.println("JSON generado desde el objeto: " + jsonOutput);
    }

    public static void main() {
        gsonPorrofSuser();
    }
}
