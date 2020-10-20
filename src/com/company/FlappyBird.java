package com.company;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlappyBird extends PApplet {
    private Bird bird = new Bird(new PVector(100, 500));
    private List<Pipe> pipes = new ArrayList<>();
    private float birdOffset = 100;
    private float lastPipeX = 0;
    private boolean isPaused = true;
    public static void main(String[] args) {
        FlappyBird
                .main(FlappyBird.class);
	// write your code here
    }


    @Override
    public void settings() {
        size(800,1000);

    }

    @Override
    public void setup() {
      //  noLoop();
    }

    @Override
    public void draw() {
        background(255);
        if(isPaused) {
            textAlign(CENTER);
            fill(255,0,0);
            text("CLICK TO START!!!!", width/2f, height/2f);
            return;
        }
        while(lastPipeX < bird.pos.x + width) {
            lastPipeX += 500;
            pipes.add(new Pipe(lastPipeX, random(0, height-250), 250));
        }
        bird.update();
        translate(-bird.pos.x + birdOffset,0);
        pipes.removeIf(pipe -> pipe.x < bird.pos.x - 150);
        for (Pipe pipe : pipes) {
            if(bird.hitsPipe(pipe)) {
                exit();
            }
            pipe.draw(getGraphics());
        }
        bird.draw(getGraphics());
      }
    public void keyPressed() {
        bird.velo.y = -6;
    }

    @Override
    public void mousePressed() {
        isPaused = !isPaused;
    }
}


