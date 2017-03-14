package com.gfb.vk_rest_client;

import com.gfb.vk_rest_client.description.photos.GetAlbumDescription;
import com.gfb.vk_rest_client.domain.AlbumPhotos;
import com.gfb.vk_rest_client.domain.Photo;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class ParseBaraholkaAlbumApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        VkontakteClient client = new VkontakteClient(args[0]);

        AlbumPhotos albumPhotos = (AlbumPhotos) client.exec(new GetAlbumDescription(
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                1000)
        );

        Date currentDate = new Date();
        String fileName = System.getProperty("user.dir") + File.separator + "baraholka-" + currentDate.getTime() + ".html";

        write(fileName, "<html><head><meta charset=\"utf-8\"></head><body>");

        String[] keywordsArr = args[3].split("[\\s]+");
        for (Photo item : albumPhotos.getItems()) {
            if (relevantLevel(item, keywordsArr) < keywordsArr.length) continue;

            String adv = decorate(item);
            write(fileName, adv);
            System.out.println(item);
        }

        write(fileName, "</body></html>");

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("file://" + fileName));
//            System.exit(0);
            // TODO: can't stop programm automaticaly if browser opened
        }
    }

    private static int relevantLevel(Photo photo, String[] keywords) {
        String text = photo.getText();
        int level = 0;
        for (String keyword : keywords) {
            if (text.contains(keyword)) level++;
        }

        return level;
    }

    private static String decorate(Photo photo) {
        return "<div>" +
                "    <a href=\"https://vk.com/photo-" + Math.abs(photo.getOwnerId()) + "_" + photo.getId() + "\" target=\"_blank\">" +
                "        <img src=\"" + photo.getPhoto604() + "\" height=\"160\"/>" +
                "    </a>" +
                "    <div>" + photo.getText() + "</div>" +
                "</div>" +
                "<hr/>";
    }

    private static void write(String fileName, String text) throws IOException {
        File yourFile = new File(fileName, "");
        if (!yourFile.exists() && yourFile.createNewFile()) {
            System.out.println("Create file: " + fileName);
        }

        FileWriter fw = new FileWriter(yourFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(text);
        out.close();
    }
}
