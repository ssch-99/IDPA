package vrphysics.sketches.gravityExperiment;

import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;

public class PlanetSelection extends BaseExperiment {
    private PShape earthSphere, moonSphere, marsSphere; //9.81, 1.62, 3.711
    private PVector earthLocation, moonLocation, marsLocation;
    private PImage sky;
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
        this.cameraUp();
        this.noStroke();
        this.sphereDetail(40);
        this.earthLocation = new PVector(0,0);
        this.moonLocation = new PVector(-500,0);
        this.marsLocation = new PVector(500,0);

        this.earthSphere = createShape(SPHERE,100);
        //this.earthSphere.setTexture(loadImage("gravityExperiment/earth.jpg"));

        this.moonSphere = createShape(SPHERE, 100);
       // this.moonSphere.setTexture(loadImage("gravityExperiment/moon.jpg"));

        this.marsSphere = createShape(SPHERE, 100);
      //  this.marsSphere.setTexture(loadImage("gravityExperiment/mars.jpeg"));

        this.sky = loadImage("gravityExperiment/sky.jpeg");
    }

    public void draw() {
        //background(sky);
        this.background(0);
        //translate(300,0, -300);
        this.shape(earthSphere, earthLocation.x, earthLocation.y);

        if (this.intersectsSphere(100, 0, 0)) {
                this.earthSphere.setTexture(loadImage("gravityExperiment/mars.jpeg"));
        } else{
            this.earthSphere.setTexture(loadImage("gravityExperiment/earth.jpg"));
        }

        //translate(300,0, 0);
        //translate(0,0,500);
        this.shape(moonSphere, moonLocation.x, moonLocation.y);

        //translate(-600,0,0);
        //translate(0,0,500);
        this.shape(marsSphere, marsLocation.x, marsLocation.y);
        this.translate(marsLocation.x, marsLocation.y,10000);
    }

    public void mousePressed(){
        start = true;
    }


    public void settings() {
        this.fullScreen(MONO);
    }
}
