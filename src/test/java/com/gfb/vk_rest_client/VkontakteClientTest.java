package com.gfb.vk_rest_client;

import com.gfb.vk_rest_client.description.newsfeed.SearchDescription;
import com.gfb.vk_rest_client.description.search.GetHintsDescription;
import com.gfb.vk_rest_client.domain.Hint;
import com.gfb.vk_rest_client.domain.NewsfeedItems;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class VkontakteClientTest {

    @Test
    public void deserializeVkResponse() throws Exception {
        VkontakteClient client = new VkontakteClient(null);

        String everything = readCassete("newsfeed.search-1.json");
        Object res1 = client.deserializeVkResponse(new SearchDescription("123456"), everything);

        Assert.assertNotNull(res1);
        Assert.assertTrue(res1 instanceof NewsfeedItems);
        Assert.assertTrue(
                ((NewsfeedItems) res1).getItems().length > 0
        );
    }

    @Test
    public void deserializeVkResponse2() throws Exception {
        VkontakteClient client = new VkontakteClient(null);

        String everything = readCassete("search.getHints-1.json");
        Object res1 = client.deserializeVkResponse(new GetHintsDescription("123456", 0), everything);

        Assert.assertNotNull(res1);
        Assert.assertTrue(res1 instanceof Hint[]);
        Assert.assertTrue(
                ((Hint[]) res1).length > 0
        );
    }

    private static String readCassete(String fileName) throws IOException, NullPointerException {

        ClassLoader classLoader = VkontakteClientTest.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        String everything;
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        return everything;
    }

}