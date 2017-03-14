package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({
        "attachments", "post_source", "comments", "geo", "reposts", "marked_as_ads", "signer_id", "copy_history"
})
public class NewsfeedItem {

    @JsonProperty
    private int id;

    @JsonProperty
    private int date;

    @JsonProperty("owner_id")
    private int ownerId;

    @JsonProperty("from_id")
    private int fromId;

    @JsonProperty("post_type")
    private String postType;

    @JsonProperty
    private String text;

    @JsonProperty
    private LikesInfo likes;

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getFromId() {
        return fromId;
    }

    @Override
    public String toString() {
        return "NewsfeedItem{" +
                "id=" + id +
                ", date=" + date +
                ", ownerId=" + ownerId +
                ", fromId=" + fromId +
                ", postType=" + postType +
                ", text=" + (text.length() > 100 ? text.substring(0, 97) + "..." : text) +
                ", likes=" + likes +
                '}';
    }
}
