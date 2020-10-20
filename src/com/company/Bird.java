package com.company;

import processing.core.PGraphics;
import processing.core.PVector;

public class Bird {
    public float size = 25;
    public PVector pos;
    public PVector velo = new PVector(2,-1);

    public boolean hitsPipe(Pipe pipe) {
        return
                (pos.x + size > pipe.x && pos.x - size < pipe.x + pipe.width) // Check if pipe overlaps on the X axis
                        && (pos.y - size < pipe.openingBeginY || pos.y + size > pipe.openingEndY);
    }

    public Bird(PVector pos) {
        this.pos = pos;
    }

    public void draw(PGraphics graphic) {
        graphic.rect(pos.x-size, pos.y-size, size*2, size*2);

    }
    public void update() {
        velo.x += 0.0005;
        velo.y += 0.2 ;
        pos.add(velo);
    }
}
