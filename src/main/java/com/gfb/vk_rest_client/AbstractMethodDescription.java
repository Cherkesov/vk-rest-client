package com.gfb.vk_rest_client;

import java.util.Map;

public abstract class AbstractMethodDescription {

    public abstract String getMethod();

    public abstract void getQueryMap(Map<String, Object> map);

    public abstract Class getResponseDomainModel();

}
