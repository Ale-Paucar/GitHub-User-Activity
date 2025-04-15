package org.alepaucar.githubuseractivity.services;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.alepaucar.githubuseractivity.models.Event;

import java.util.ArrayList;
import java.util.List;

public class ParseJsonService {
    private ParseJsonService(){};

    public static List<Event> parse(String rawJson){
        JsonParser parser = new JsonParser();
        JsonArray gsonArray = parser.parse(rawJson).getAsJsonArray();
        List<Event> allEvents = new ArrayList<>();

        for (JsonElement obj:gsonArray){
            JsonObject gsonObj = obj.getAsJsonObject();
            String type = gsonObj.get("type").getAsString();
            JsonObject repo = gsonObj.get("repo").getAsJsonObject();
            int repoID = repo.get("id").getAsInt();
            String repoName = repo.get("name").getAsString();
            JsonObject payload = gsonObj.get("payload").getAsJsonObject();

            int commitsSize = -1;
            String action = null;
            String issueTitle = null;
            String description = null;


            switch (type) {
                case "CreateEvent":
                    description = payload.has("description") ? payload.get("description").getAsString() : null;
                    break;

                case "PushEvent":

                    if (payload.has("size")) {
                        commitsSize = payload.get("size").getAsInt();
                    }
                    break;

                case "IssuesEvent":

                    if (payload.has("action") && payload.has("issue")) {
                        action = payload.get("action").getAsString();
                        issueTitle = payload.get("issue").getAsJsonObject().get("title").getAsString();
                    }
                    break;
            }

            // Crear el objeto Event con la información del CreateEvent
            allEvents.add(new Event(type, repoID, repoName, commitsSize, action, issueTitle, description));
        }

        return allEvents;
    }
}
