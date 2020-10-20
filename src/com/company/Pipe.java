package com.company;

import processing.core.PGraphics;

public class Pipe {

    public float x;
    public float openingBeginY;
    public float openingEndY;
    public float width = 50;

    public Pipe(float x, float gapPos, float gapSize) {
        this.x = x;
        this.openingBeginY = gapPos;
        this.openingEndY = gapPos + gapSize;
    }

//    public Pipe(float x, float openingBeginY, float openingEndY) {
//        this.x = x;
//        this.openingBeginY = openingBeginY;
//        this.openingEndY = openingEndY;
//    }

    public void draw(PGraphics graphic) {
        graphic.rect(x, 0, width, openingBeginY);
        graphic.rect(x, openingEndY, width, graphic.height-openingEndY);
    }
}
