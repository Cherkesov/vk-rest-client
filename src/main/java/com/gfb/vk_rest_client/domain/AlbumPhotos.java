package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class AlbumPhotos {

    @JsonProperty
    private int count;

    @JsonProperty
    private Photo[] items;

    public int getCount() {
        return count;
    }

    public Photo[] getItems() {
        return items;
    }
}
