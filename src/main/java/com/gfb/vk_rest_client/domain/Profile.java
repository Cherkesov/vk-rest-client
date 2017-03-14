package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by goforbroke on 14.03.17.
 */
public class Profile {

    @JsonProperty
    private int id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                '}';
    }
}
