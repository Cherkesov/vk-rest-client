package com.gfb.vk_rest_client;

import com.gfb.vk_rest_client.description.newsfeed.SearchDescription;
import com.gfb.vk_rest_client.domain.NewsfeedItem;
import com.gfb.vk_rest_client.domain.NewsfeedItems;

public class Application {

    public static void main(String[] args) {
        VkontakteClient client = new VkontakteClient(args[0]);


//        System.out.println("========== Use \"search.getHints\" ==========");
//        Hint[] hints = (Hint[]) client.exec(new GetHintsDescription("hello", 10));
//        for (Hint hint : hints) {
//            System.out.println(hint);
//        }
//        System.out.println();


        System.out.println("========== Use \"newsfeed.search\" ==========");
        NewsfeedItems items = (NewsfeedItems) client.exec(new SearchDescription("hello"));
        for (NewsfeedItem item : items.getItems()) {
            System.out.println(item);
        }
        System.out.println();
    }
}
