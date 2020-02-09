package vrphysics.sketches.gravityExperiment;

import java.util.concurrent.TimeUnit;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.MainActivity;
import vrphysics.experiment.BaseExperiment;

public class PlanetSelection extends BaseExperiment {
    private PShape earth, moon, mars,sphere; //9.81, 1.62, 3.711
    private PVector earthLocation, moonLocation, marsLocation,spehreLocation;
    private Boolean start = false;
    private MainActivity mainActivity;

    private Boolean showPlanets = true;

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


    public void setup() {
        MainActivity activity = (MainActivity) getActivity();
        System.out.println(activity);
        this.cameraUp();
        this.noStroke();
        this.sphereDetail(40);
        this.earthLocation = new PVector(0, 0);
        this.moonLocation = new PVector(-600, 0);
        this.marsLocation = new PVector(600, 0);

        this.earth = createShape(SPHERE, 101);
        this.earth.setTexture(loadImage("gravityExperiment/earth.jpg"));

        this.moon = createShape(SPHERE, 99);
        this.moon.setTexture(loadImage("gravityExperiment/moon.jpg"));

        this.mars = createShape(SPHERE, 100);
        this.mars.setTexture(loadImage("gravityExperiment/mars.jpeg"));

        this.sphere = createShape(SPHERE, 80);

        spehreLocation = new PVector(0,500,1000);
        mainActivity = (MainActivity) this.getActivity();
    }

    public void draw() {
        this.background(0);

        //Planeten anzeigen
        if (showPlanets) {
            // Erde
            if (this.intersectsSphere(101, 0, 0)) {
                System.out.println("Hit earth");
                this.earth.setTint(color(255, 200, 200, 230));

                if (mousePressed) {

                    showPlanets = false;
                }

            } else {
                // System.out.println("No hit earth");
                this.earth.setTint(color(255));
            }

            //Mond
            if (this.intersectsSphere(99, 600, 0)) {
                System.out.println("Hit moon");
                this.moon.setTint(color(255, 200, 200, 230));



            } else {
                // System.out.println("No hit moon");
                this.moon.setTint(color(255));
            }

            //Mars
            if (this.intersectsSphere(100, -600, 0)) {
                System.out.println("Hit mars");
                this.mars.setTint(color(255, 200, 200, 230));


            } else {
                // System.out.println("No hit mars");
                this.mars.setTint(color(255));

            }


            this.shape(earth, earthLocation.x, earthLocation.y);
            this.shape(moon, moonLocation.x, moonLocation.y);
            this.shape(mars, marsLocation.x, marsLocation.y);
        }else{
            //Kugel laden
            this.shape(sphere,spehreLocation.x,spehreLocation.y,200.0f,200.0f);

            double velocity = 9.81;
            int count = 1;
            if(start){
                if(this.spehreLocation.y > -700) {
                    this.spehreLocation.y -= count * velocity;

                }else{
                    try {
                        TimeUnit.SECONDS.sleep(3);
                       start = false;
                       showPlanets = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count += 1;
            }
        }
    }

    public void settings() {
        this.fullScreen(MONO);
    }


    public void mousePressed(){

        if(!showPlanets){
            start = true;
        }
    }



    public void stop() {
        System.err.println("STOP STOP");
       /* MainActivity mainActivity = (MainActivity) this.getActivity();
        mainActivity.setSketch(new GravityExperiment());
        String[] test = new String[1];
        test[0] = "GravityExperiment";
        PApplet.main(test);*/

        this.exit();

        System.err.println("FINISHED");

        mainActivity.setSketch(new GravityExperiment());
        System.err.println("STOP AFTER");

    }

}
