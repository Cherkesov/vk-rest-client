package com.gfb.vk_rest_client.description.photos;

import com.gfb.vk_rest_client.AbstractMethodDescription;
import com.gfb.vk_rest_client.domain.AlbumPhotos;

import java.util.Map;

public class GetAlbumDescription extends AbstractMethodDescription {
    private static final int MAX_COUNT = 1000;

    private int ownerId;
    private int albumId;
    private int count;

    public GetAlbumDescription(int ownerId, int albumId) {
        this(ownerId, albumId, MAX_COUNT);
    }

    public GetAlbumDescription(int ownerId, int albumId, int count) {
        this.ownerId = ownerId;
        this.albumId = albumId;
        this.count = count;
    }

    public String getMethod() {
        return "photos.get";
    }

    public void getQueryMap(Map<String, Object> map) {
        map.put("owner_id", ownerId);
        map.put("album_id", albumId);
        map.put("count", count);
        map.put("rev", 0);
    }

    public Class getResponseDomainModel() {
        return AlbumPhotos.class;
    }
}
