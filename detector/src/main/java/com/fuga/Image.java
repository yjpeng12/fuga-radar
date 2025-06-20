package com.fuga;

import java.util.List;

public class Image {

    public List<String> imageList;
    public int rowCount;
    public int colCount;

    public Image(List<String> imageList) {
        this.imageList = imageList;
        this.rowCount = imageList.size();
        this.colCount = imageList.get(0).length();
    }
}
