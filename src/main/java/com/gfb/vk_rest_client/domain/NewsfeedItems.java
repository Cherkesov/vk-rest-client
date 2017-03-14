package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class NewsfeedItems {

    @JsonProperty
    private NewsfeedItem[] items;

    @JsonProperty
    private int count;

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("next_from")
    private String nextFrom;

    public NewsfeedItem[] getItems() {
        return items;
    }

    public int getCount() {
        return count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public String getNextFrom() {
        return nextFrom;
    }
}
