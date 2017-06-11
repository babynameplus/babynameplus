package com.babynameplus.dto;

/**
 * Created by spio10 on 2017-06-04.
 */
public class SearchOptions {

    private String letter;
    private String origin;
    private String isRandom;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) { this.origin = origin;    }

    public String getIsRandom() {
        return isRandom;
    }
    public void setIsRandom(String isRandom) {this.isRandom = isRandom;}
}
