package com.fuga.matchers;

import java.util.List;

import com.fuga.Image;

public interface ImageMatcher {
    public List<MatchResult> match(Image image, Image pattern);
}
