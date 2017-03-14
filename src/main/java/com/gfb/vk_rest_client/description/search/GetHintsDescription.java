package com.gfb.vk_rest_client.description.search;

import com.gfb.vk_rest_client.AbstractMethodDescription;
import com.gfb.vk_rest_client.domain.Hint;

import java.util.Map;

public class GetHintsDescription extends AbstractMethodDescription {

    private String query;
    private int limit;

    public GetHintsDescription(String query, int limit) {
        this.query = query;
        this.limit = limit;
    }

    public String getMethod() {
        return "search.getHints";
    }

    @Override
    public void getQueryMap(Map<String, Object> map) {
        map.put("q", query);
        map.put("limit", limit);
    }

    public Class getResponseDomainModel() {
        return Hint[].class;
    }
}
