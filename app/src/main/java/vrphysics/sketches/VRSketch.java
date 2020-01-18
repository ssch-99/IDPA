package vrphysics.sketches;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.vr.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class VRSketch extends PApplet {
    public void setup() {
        fullScreen(VR);
    }
    public void settings() {
        fullScreen(VR);
    }

    public void draw() {
        background(80);
        directionalLight(204, 204, 204, 1, 1, -1);
    }
}
