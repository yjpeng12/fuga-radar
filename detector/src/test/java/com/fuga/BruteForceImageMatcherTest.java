package com.fuga;

import org.junit.jupiter.api.Test;

import com.fuga.matchers.BruteForceImageMatcher;
import com.fuga.matchers.ImageMatcher;
import com.fuga.matchers.MatchResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

class BruteForceImageMatcherTest {

    @Test
    void testMatcher_no_noise() {
        ImageMatcher imageMatcher = new BruteForceImageMatcher(0);

        List<MatchResult> results = imageMatcher.match(
            new Image(Arrays.asList("--oo--")),
            new Image(Arrays.asList("--o--"))
        );
        assertEquals(Arrays.asList(), results);

        results = imageMatcher.match(
            new Image(Arrays.asList("o")),
            new Image(Arrays.asList("--o--"))
        );
        assertEquals(Arrays.asList(), results);

        results = imageMatcher.match(
            new Image(Arrays.asList(
                "--oo--",
                "oooooo"
            )),
            new Image(Arrays.asList(
                "oo",
                "oo"
            ))
        );
        assertEquals(
            Arrays.asList(
                new MatchResult(
                    new Image(Arrays.asList(
                   "oo",
                        "oo"
                    )),
                    0,
                    2
                )
            ),
            results
        );
    }

    void testMatcher_with_noise() {
        ImageMatcher imageMatcher = new BruteForceImageMatcher(2);

        List<MatchResult> results = imageMatcher.match(
            new Image(Arrays.asList("--oo-o-")),
            new Image(Arrays.asList("--o--"))
        );
        assertEquals(
            Arrays.asList(
                new MatchResult(
                    new Image(Arrays.asList("--o--")),
                    0,
                    0
                )
            ),
            results
        );

        results = imageMatcher.match(
            new Image(Arrays.asList("--ooo-o-")),
            new Image(Arrays.asList("--o--"))
        );
        assertEquals(Arrays.asList(), results);
    }
}
