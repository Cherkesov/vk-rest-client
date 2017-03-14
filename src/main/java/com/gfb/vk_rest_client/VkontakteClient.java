package com.gfb.vk_rest_client;

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
import java.util.LinkedHashMap;
import java.util.Map;

public class VkontakteClient {
    private static final String VERSION = "5.62";
    private static final String VK_API_BASE_URL = "https://api.vk.com/method/";

    private String accessToken;
    private Client client;
    private JsonParser parser;
    private ObjectMapper mapper;

    public VkontakteClient(String accessToken) {
        this.accessToken = accessToken;
        client = ClientBuilder.newClient();
        parser = new JsonParser();
        mapper = new ObjectMapper();
    }

    public Object exec(AbstractMethodDescription description) {

        WebTarget target = client
                .target(VK_API_BASE_URL)
                .path(description.getMethod())
                .queryParam("access_token", accessToken)
                .queryParam("v", VERSION);

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        description.getQueryMap(map);
        for (Map.Entry<String, Object> param : map.entrySet()) {
            target = target.queryParam(param.getKey(), param.getValue());
        }

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(""));

        String responseContent = response.readEntity(String.class);

        return deserializeVkResponse(description, responseContent);
    }

    public Object deserializeVkResponse(AbstractMethodDescription description, String responseContent) {
        JsonObject mainObject = parser.parse(responseContent).getAsJsonObject();
        JsonElement responseItem = mainObject.get("response");

        Object result = null;
        try {
            result = mapper.readValue(responseItem.toString(), description.getResponseDomainModel());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
