package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by goforbroke on 14.03.17.
 */
public class HintGroup extends Hint {

    @JsonProperty
    private Group group;

    @Override
    public String toString() {
        return "HintGroup{" +
                "group=" + group +
                '}';
    }
}
