package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class LikesInfo {

    @JsonProperty("count")
    private int count;

    @JsonProperty("user_likes")
    private int userLikes;

    @JsonProperty("can_like")
    private boolean canLike;

    @JsonProperty("can_publish")
    private boolean canPublish;

    public int getCount() {
        return count;
    }

    public int getUserLikes() {
        return userLikes;
    }

    public boolean isCanLike() {
        return canLike;
    }

    public boolean isCanPublish() {
        return canPublish;
    }

    @Override
    public String toString() {
        return "LikesInfo{" +
                "count='" + count + '\'' +
                ", userLikes='" + userLikes + '\'' +
                ", canLike=" + canLike +
                ", canPublish=" + canPublish +
                '}';
    }
}
