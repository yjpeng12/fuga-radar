package com.fuga.matchers;

import com.fuga.Image;

public class MatchResult {
    public Image image;
    public int row;
    public int col;

    public MatchResult(Image image, int row, int col) {
        this.image = image;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.row).append(", ").append(this.col).append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MatchResult)) {
            return false;
        }

        MatchResult matchResult = (MatchResult) obj;
        return (this.image.imageList.equals(matchResult.image.imageList) && this.row == matchResult.row
                && this.col == matchResult.col);
    }
}
