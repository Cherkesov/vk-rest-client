package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by goforbroke on 14.03.17.
 */
public class HintProfile extends Hint {

    @JsonProperty
    private Profile profile;

    @Override
    public String toString() {
        return "HintProfile{" +
                "profile=" + profile +
                '}';
    }
}
