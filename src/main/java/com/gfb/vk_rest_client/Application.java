package com.gfb.vk_rest_client;

import com.gfb.vk_rest_client.domain.Hint;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class Application {

    private static final String METHOD__SEARCH_GET_HINTS = "search.getHints";
    private static final String VERSION = "5.62";

    public static void main(String[] args) {

        /*
         * https://oauth.vk.com/authorize?client_id=5879268&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,groups&response_type=token&v=5.62&state=123456
         */

        Client client = ClientBuilder.newClient();
        WebTarget target = client
                .target("https://api.vk.com/method/")
                .path(METHOD__SEARCH_GET_HINTS)
                .queryParam("q", "Hello")
                .queryParam("limit", 10)
                .queryParam("access_token", args[0])
                .queryParam("v", VERSION);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(""))
                ;

        String responseContent = response.readEntity(String.class);

        JsonParser parser = new JsonParser();
        JsonObject mainObject = parser.parse(responseContent).getAsJsonObject();
        JsonArray pItem = mainObject.getAsJsonArray("response");

        ObjectMapper mapper = new ObjectMapper();

        for (JsonElement row : pItem) {
            try {
                Hint user = mapper.readValue(row.toString(), Hint.class);
                System.out.println(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
