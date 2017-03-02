package com.gfb.vk_rest_client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by goforbroke on 02.03.17.
 */
public class Application {

    public static final String METHOD__SEARCH_GET_HINTS = "search.getHints";
    public static final String VERSION = "5.62";

    public static void main(String[] args) {

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

        System.out.println(response.readEntity(String.class));
    }
}
