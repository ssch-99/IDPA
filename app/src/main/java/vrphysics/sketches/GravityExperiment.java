package vrphysics.sketches;

import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;

public class GravityExperiment extends BaseExperiment {
    PShape earthSphere; //9.81
    PVector earthLocation;
    PShape moonSphere; //1.62
    PVector moonLocation;
    PShape marsSphere; //3.711
    PVector marsLocation;
    PImage sky;
    Boolean start = false;

    @Override
    public String getTitle() {
        return "Gravity Experiment";
    }

    @Override
    public String getDescription() {
        return "Simulates some planets with different gravitational accelerations";
    }

    @Override
    public String getImageFilePath() {
        return "gravityExperiment/thumbnail.png";
    }


    public void calculate() {

    }

    public void setup() {
        cameraUp();
        noStroke();
        sphereDetail(40);
        earthLocation = new PVector(0,0);
        moonLocation = new PVector(-500,0);
        marsLocation = new PVector(500,0);

        earthSphere = createShape(SPHERE,100);
        earthSphere.setTexture(loadImage("./gravityExperiment/earth.jpg"));

        moonSphere = createShape(SPHERE, 100);
        moonSphere.setTexture(loadImage("./gravityExperiment/moon.jpg"));

        marsSphere = createShape(SPHERE, 100);
        marsSphere.setTexture(loadImage("./gravityExperiment/mars.jpeg"));

        sky = loadImage("gravityExperiment/sky.jpeg");
    }

    public void draw() {
        if(start){
            //if(locationEarth.y > 0){
            earthLocation.y -= 9.81f;
            //}
            //if(locationMoon.y > 0){
            moonLocation.y -= 1.62f;
            // }
            //if(locationMars.x > 0){
            marsLocation.y -= 3.711f;
            //}
        }

        //background(sky);
        background(0);
        //translate(300,0, -300);
        shape(earthSphere, earthLocation.x, earthLocation.y);

        //translate(300,0, 0);
        //translate(0,0,500);
        shape(moonSphere, moonLocation.x, moonLocation.y);

        //translate(-600,0,0);
        //translate(0,0,500);
        shape(marsSphere, marsLocation.x, marsLocation.y);
        translate(marsLocation.x, marsLocation.y,10000);
    }

    public void mousePressed(){
        start = true;
    }


    public void settings() {  fullScreen(VR); }
}
