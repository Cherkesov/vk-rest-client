package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = HintProfile.class, name = "profile"),
        @JsonSubTypes.Type(value = HintGroup.class, name = "group")
})
public abstract class Hint {

    @JsonProperty
    protected String type;

    @JsonProperty
    protected String section;

    @JsonProperty
    protected String description;

    @JsonProperty
    protected boolean global;
}
