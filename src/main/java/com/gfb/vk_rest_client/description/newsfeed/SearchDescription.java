package com.gfb.vk_rest_client.description.newsfeed;

import com.gfb.vk_rest_client.AbstractMethodDescription;
import com.gfb.vk_rest_client.domain.NewsfeedItems;

import java.util.Map;

public class SearchDescription extends AbstractMethodDescription {
    private String query;

    public SearchDescription(String query) {
        this.query = query;
    }

    public String getMethod() {
        return "newsfeed.search";
    }

    public void getQueryMap(Map<String, Object> map) {
        map.put("q", query);
    }

    public Class getResponseDomainModel() {
        return NewsfeedItems.class;
    }
}
