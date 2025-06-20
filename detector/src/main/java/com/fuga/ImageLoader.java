package com.fuga;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImageLoader {
    static public Image load(String filePath) {
        List<String> imageList = new ArrayList<>();
        try {
            File file = new File(filePath);
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    imageList.add(data);
                }
            }
        } catch (Exception e) {
            System.out.println("Path " + filePath + " not found");
            e.printStackTrace();
        }
        return new Image(imageList);
    }
}
