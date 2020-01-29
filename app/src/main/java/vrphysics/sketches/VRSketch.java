package vrphysics.sketches;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.vr.*;
import vrphysics.experiment.BaseExperiment;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class VRSketch extends PApplet {
    private SketchMode sketchMode;
    private BaseExperiment experiment;
    private Menu menu;

    public void setup() {
        this.menu = new Menu(this);
        this.sketchMode = SketchMode.MENU;
        cameraUp();
    }
    public void settings() {
        fullScreen(MONO);
    }

    public void calculate() {
        switch (this.sketchMode) {
            case MENU:
                this.menu.calculate();
            case SIMULATION:
                this.experiment.calculate();
            default:
                break;
        }
    }

    public void draw() {
        switch (this.sketchMode) {
            case MENU:
                this.menu.draw();
            case SIMULATION:
                this.experiment.draw();
            default:
                break;
        }
    }

    public void touchStarted() {
        switch (this.sketchMode) {
            case MENU:
                this.menu.draw();
            case SIMULATION:
                this.experiment.draw();
            default:
                break;
        }
    }

    public void touchMoved() {
        switch (this.sketchMode) {
            case MENU:
            case SIMULATION:
            default:
                break;
        }
    }

    public void touchEnded() {
        switch (this.sketchMode) {
            case MENU:
            case SIMULATION:
            default:
                break;
        }
    }

    public void changeMode(SketchMode mode) {
        this.sketchMode = mode;
    }
}
