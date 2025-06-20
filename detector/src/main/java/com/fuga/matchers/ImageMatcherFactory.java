package com.fuga.matchers;

public class ImageMatcherFactory {
    public static ImageMatcher getImageMatcher(int maxAllowedNoise) {
        return new BruteForceImageMatcher(maxAllowedNoise);
    }
}
