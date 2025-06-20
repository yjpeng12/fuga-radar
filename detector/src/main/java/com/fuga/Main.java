package com.fuga;

import java.util.Arrays;
import java.util.List;

import com.fuga.matchers.BruteForceImageMatcher;
import com.fuga.matchers.ImageMatcher;

public class Main {
    static public void main(String[] args) {
        int maxAllowedNoise = 10;
        ImageMatcher imageMatcher = new BruteForceImageMatcher(maxAllowedNoise);

        Radar radar = new Radar(imageMatcher);
        Image radarImage = ImageLoader.load("detector/images/radar.txt");
        Invader invader1 = new Invader("invader_1", new Image(Arrays.asList(
                "--o-----o--",
                "---o---o---",
                "--ooooooo--",
                "-oo-ooo-oo-",
                "ooooooooooo",
                "o-ooooooo-o",
                "o-o-----o-o",
                "---oo-oo---")));
        radar.addInvader(invader1);

        Invader invader2 = new Invader("invader_2", new Image(Arrays.asList(
                "---oo---",
                "--oooo--",
                "-oooooo-",
                "oo-oo-oo",
                "oooooooo",
                "--o--o--",
                "-o-oo-o-",
                "o-o--o-o")));
        radar.addInvader(invader2);

        List<DetectResult> detectResults = radar.detect(radarImage);
        for (DetectResult detectResult : detectResults) {
            System.out.println(detectResult.toString());
        }
    }
}
