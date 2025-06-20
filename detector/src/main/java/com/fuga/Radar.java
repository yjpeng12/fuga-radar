package com.fuga;

import java.util.ArrayList;
import java.util.List;

import com.fuga.matchers.*;

class DetectResult {
    Invader invader;
    MatchResult matchResult;

    public DetectResult(Invader invader, MatchResult matchResult) {
        this.invader = invader;
        this.matchResult = matchResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.invader.id).append(" [").append(this.matchResult.row).append(", ").append(this.matchResult.col)
                .append("]");
        return sb.toString();
    }
}

public class Radar {
    ImageMatcher imageMatcher;
    List<Invader> invaders;

    // For testing purpose
    public Radar(ImageMatcher imageMatcher) {
        this.imageMatcher = imageMatcher;
        this.invaders = new ArrayList<>();
    }

    public void addInvader(Invader invader) {
        this.invaders.add(invader);
    }

    public List<DetectResult> detect(Image radarImage) {
        List<DetectResult> detectResults = new ArrayList<>();

        for (Invader invader : invaders) {
            List<MatchResult> matchResults = imageMatcher.match(radarImage, invader.image);
            for (MatchResult matchResult : matchResults) {
                detectResults.add(new DetectResult(invader, matchResult));
            }
        }

        return detectResults;
    }
}
