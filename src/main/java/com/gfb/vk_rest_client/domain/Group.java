package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({
        "admin_level"
})
public class Group {
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty("screen_name")
    private String screenName;

    @JsonProperty("is_closed")
    private boolean isClosed;

    @JsonProperty
    private String type;

    @JsonProperty("is_admin")
    private boolean isAdmin;

    @JsonProperty("is_member")
    private boolean isMember;

    @JsonProperty("photo_50")
    private String photo50;

    @JsonProperty("photo_100")
    private String photo100;

    @JsonProperty("photo_200")
    private String photo200;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public String getType() {
        return type;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isMember() {
        return isMember;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                '}';
    }
}
