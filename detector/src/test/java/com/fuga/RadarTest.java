package com.fuga;

import org.junit.jupiter.api.Test;

import com.fuga.matchers.ImageMatcher;
import com.fuga.matchers.MatchResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

/**
 * Image matcher fake to match exact the same images
 */
class ExactMatchImageMatcher implements ImageMatcher {

    @Override
    public List<MatchResult> match(Image image, Image pattern) {
        if (image.imageList.equals(pattern.imageList)) {
            return Arrays.asList(new MatchResult(pattern, 0, 0));
        } else {
            return Arrays.asList();
        }
    }

}

class RadarTest {

    @Test
    void testRadar() {

        Invader invader1 = new Invader("invader_1", new Image(Arrays.asList("-o-", "ooo")));

        Invader invader2 = new Invader("invader_2", new Image(Arrays.asList("---", "---")));

        ImageMatcher exactMatchImageMatcher = new ExactMatchImageMatcher();
        Radar radar = new Radar(exactMatchImageMatcher);
        radar.addInvader(invader1);
        radar.addInvader(invader2);

        List<DetectResult> result = radar.detect(new Image(Arrays.asList("-o-", "ooo")));
        assertEquals(1, result.size());
        assertEquals("invader_1", result.get(0).invader.id);

        result = radar.detect(new Image(Arrays.asList("---", "---")));
        assertEquals(1, result.size());
        assertEquals("invader_2", result.get(0).invader.id);

        result = radar.detect(new Image(Arrays.asList("000", "ooo")));
        assertEquals(0, result.size());
    }
}
