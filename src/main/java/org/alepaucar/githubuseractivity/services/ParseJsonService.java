package org.alepaucar.githubuseractivity.services;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.alepaucar.githubuseractivity.models.Event;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonService {

    private ParseJsonService(){};

    public static List<Event> parseJsonToEvents(String rawJson){
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
            String dateString = gsonObj.get("created_at").getAsString();
            //parseo
            OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);
            LocalDateTime date = offsetDateTime.toLocalDateTime();

            int commitsSize = -1;
            String action = null;
            String issueTitle = null;
            String description = null;


            switch (type) {
                case "CreateEvent":
                    //Aca habia un porblema cuando a veces si existe la key "description" pero el value es null
                    description = payload.has("description") && !payload.get("description").isJsonNull()
                            ? payload.get("description").getAsString()
                            : null;
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
            allEvents.add(new Event(type, repoID, repoName, commitsSize, action, issueTitle, description, date));
        }

        return allEvents;
    }
}
