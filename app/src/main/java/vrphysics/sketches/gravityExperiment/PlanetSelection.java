package vrphysics.sketches.gravityExperiment;

import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;

public class PlanetSelection extends BaseExperiment {
    private PShape earth, moonSphere, marsSphere; //9.81, 1.62, 3.711
    private PVector earthLocation, moonLocation, marsLocation;
    private PImage sky;
    Boolean start = false;
    PVector origin = new PVector();


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
        //this.earthLocation = new PVector(0,0);
        //this.moonLocation = new PVector(-500,0);
        //this.marsLocation = new PVector(500,0);

        this.earth = createShape(SPHERE,100);
        this.earth.setTexture(loadImage("gravityExperiment/earth.jpg"));

        //this.moonSphere = createShape(SPHERE, 100);
       // this.moonSphere.setTexture(loadImage("gravityExperiment/moon.jpg"));

       // this.marsSphere = createShape(SPHERE, 100);
      //  this.marsSphere.setTexture(loadImage("gravityExperiment/mars.jpeg"));

        this.sky = loadImage("gravityExperiment/sky.jpeg");
    }

    public void draw() {
        this.background(0);
        if (this.intersectsSphere(100, 0, 0)) {
            System.out.println("Hit");
            this.earth.setTint(color(255, 200, 200, 230));
        } else {
            System.out.println("No hit");
            this.earth.setTint(color(255));
        }

        this.shape(earth);
    }

    public void mousePressed(){
        start = true;
    }


    public void settings() {
        this.fullScreen(MONO);
    }
}
