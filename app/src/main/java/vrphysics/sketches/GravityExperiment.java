package vrphysics.sketches;

import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.MainActivity;
import vrphysics.experiment.BaseExperiment;

public class GravityExperiment extends BaseExperiment {

    PShape earthSpehre; //9.81
    PVector locationEarth;
    PShape moonSpehre; //1.62
    PVector locationMoon;
    PShape marsSpehre; //3.711
    PVector locationMars;
    PImage sky;

    Boolean start = false;
    int numberOfPresses = 0;


    @Override
    public String getTitle() {
        return "SampleExperiment A";
    }

    @Override
    public String getDescription() {
        return "Some nice description";
    }

    @Override
    public String getImageFileName() {
        return "";
    }


    public void calculate() {

    }

    public void setup() {

        cameraUp();

        noStroke();
        sphereDetail(40);
        locationEarth = new PVector(0,0);
        locationMoon = new PVector(-500,0);
        locationMars = new PVector(500,0);


        earthSpehre = createShape(SPHERE,100);
        earthSpehre.setTexture(loadImage("earth.jpg"));

        moonSpehre = createShape(SPHERE, 100);
        moonSpehre.setTexture(loadImage("moon.jpg"));

        marsSpehre = createShape(SPHERE, 100);
        marsSpehre.setTexture(loadImage("mars.jpeg"));

        sky = loadImage("sky.jpeg");


    }

    public void draw() {

        if(start){

            //if(locationEarth.y > 0){
            locationEarth.y -= 9.81f;
            //}
            //if(locationMoon.y > 0){
            locationMoon.y -= 1.62f;
            // }
            //if(locationMars.x > 0){
            locationMars.y -= 3.711f;
            //}

        }
        //background(sky);
        background(0);
        //translate(300,0, -300);
        shape(earthSpehre, locationEarth.x,locationEarth.y);
        //translate(300,0, 0);
        //translate(0,0,500);
        shape(moonSpehre, locationMoon.x,locationMoon.y);

        //translate(-600,0,0);
        //translate(0,0,500);
        shape(marsSpehre, locationMars.x,locationMars.y);
        translate(locationMars.x,locationMars.y,10000);


    }

    public void mousePressed(){
        start = true;
    }


    public void settings() {  fullScreen(VR); }


}
