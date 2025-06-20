package com.fuga.matchers;

import java.util.ArrayList;
import java.util.List;

import com.fuga.Image;

public class BruteForceImageMatcher implements ImageMatcher {

    int maxAllowedNoise;

    public BruteForceImageMatcher(int maxAllowedNoise) {
        this.maxAllowedNoise = maxAllowedNoise;
    }

    @Override
    public List<MatchResult> match(Image image, Image pattern) {
        List<MatchResult> results = new ArrayList<>();
        if (pattern.rowCount > image.rowCount || pattern.colCount > image.colCount) {
            return results;
        }

        for (int r = 0; r <= image.rowCount - pattern.rowCount; r++) {
            for (int c = 0; c <= image.colCount - pattern.colCount; c++) {
                MatchResult result = matchImage(image, pattern, r, c);
                if (result != null) {
                    results.add(result);
                }
            }
        }

        return results;
    }

    private MatchResult matchImage(Image image, Image pattern, int r, int c) {
        int mismatchCount = 0;
        for (int x = 0; x < pattern.rowCount; x++) {
            for (int y = 0; y < pattern.colCount; y++) {
                if (pattern.imageList.get(x).charAt(y) != image.imageList.get(r + x).charAt(c + y)) {
                    mismatchCount++;
                }
            }
        }

        if (mismatchCount <= this.maxAllowedNoise) {
            return new MatchResult(pattern, r, c);
        }

        return null;
    }

}
