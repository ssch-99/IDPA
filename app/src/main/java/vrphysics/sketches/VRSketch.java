package vrphysics.sketches;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.vr.*;
import vrphysics.Sketch;
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
    private HashMap<String, Sketch> sketchList;
    private SketchMode sketchMode;
    private Sketch currentSketch;

    private void onModeChanged() {

    }

    private void resetEnvironment() {

    }

    private void changeMode(SketchMode mode) {
        this.sketchMode = mode;
        this.onModeChanged();
    }

    public void setup() {
        this.sketchList = new HashMap<String, Sketch>();
        this.sketchList.put("Menu", new Menu(this));
        this.sketchMode = SketchMode.MENU;
        this.switchToSketch("Menu");
        cameraUp();
    }

    public void settings() {
        fullScreen(MONO);
    }

    public void calculate() {
        this.currentSketch.calculate();
    }

    public void draw() {
        this.currentSketch.draw();
    }

    public void touchStarted() {

    }

    public void touchMoved() {

    }

    public void touchEnded() {

    }

    public void switchToSketch(String sketchName) {
        this.currentSketch = this.sketchList.get(sketchName);
        this.resetEnvironment();
    }
}
