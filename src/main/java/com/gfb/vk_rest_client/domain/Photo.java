package com.gfb.vk_rest_client.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties({
        "lat", "long"
})
public class Photo {

    @JsonProperty
    private int id;

    @JsonProperty("album_id")
    private int albumId;

    @JsonProperty("owner_id")
    private int ownerId;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("photo_75")
    private String photo75;

    @JsonProperty("photo_130")
    private String photo130;

    @JsonProperty("photo_604")
    private String photo604;

    @JsonProperty("photo_807")
    private String photo807;

    @JsonProperty("photo_1280")
    private String photo1280;

    @JsonProperty("photo_2560")
    private String photo2560;

    @JsonProperty
    private int width;

    @JsonProperty
    private int height;

    @JsonProperty
    private String text;

    @JsonProperty
    private int date;

    public int getId() {
        return id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public String getPhoto807() {
        return photo807;
    }

    public String getPhoto1280() {
        return photo1280;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public int getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", ownerId=" + ownerId +
                ", userId=" + userId +
                ", photo604='" + photo604 + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", text='" + (text.length() > 100 ? text.substring(0, 97) + "..." : text) + '\'' +
                ", date=" + date +
                '}';
    }
}
