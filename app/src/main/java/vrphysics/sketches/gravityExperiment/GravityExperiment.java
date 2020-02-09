package vrphysics.sketches.gravityExperiment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.MainActivity;
import vrphysics.experiment.BaseExperiment;

public class GravityExperiment extends BaseExperiment {
    private List<Planet> planets = new ArrayList<>();


    private PShape earth, moon, mars,sphere; //9.81, 1.62, 3.711
    private PVector earthLocation, moonLocation, marsLocation,spehreLocation;
    private Boolean start = false;
    private MainActivity mainActivity;
    private Planet selectedPlanet = null;

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


    //String name, String description, Float gravity, String imagePlanet, String imageGround, PVector location
    private void initPlanets(){
        //Bilder von https://www.solarsystemscope.com/textures/
        Planet mercury = new Planet("Merkur","Der Merkur ist mit einem Durchmesser von knapp 4880 Kilometern der kleinste, mit einer durchschnittlichen Sonnenentfernung von etwa 58 Millionen Kilometern der sonnennächste und somit auch schnellste Planet im Sonnensystem.",
                100,3.7f,"gravityExperiment/mercury.jpg","",new PVector(-500,0));

        Planet venus = new Planet("Venus","Die Venus ist mit einer durchschnittlichen Sonnenentfernung von 108 Millionen Kilometern der zweitinnerste und mit einem Durchmesser von ca. 12.100 Kilometern der drittkleinste Planet des Sonnensystems.",
                100,8.87f,"gravityExperiment/venus.jpg","",new PVector(-501,-500));

        Planet earth = new Planet("Erde","Die Erde ist der dichteste, fünftgrößte und der Sonne drittnächste Planet des Sonnensystems. Sie ist Ursprungsort und Heimat aller bekannten Lebewesen.",
                100,9.81f, "gravityExperiment/earth.jpg","",new PVector(0, 0));

        Planet mars = new Planet("Mars","Der Mars ist, von der Sonne aus gezählt, der vierte Planet im Sonnensystem und der äußere Nachbar der Erde. Er zählt zu den erdähnlichen Planeten.",
                99,3.711f,"gravityExperiment/mars.jpg","",new PVector(1, -500));

        Planet jupiter = new Planet("Jupiter","Jupiter ist mit einem Äquatordurchmesser von rund 143.000 Kilometern der größte Planet des Sonnensystems.",
                100,24.79f,"gravityExperiment/jupiter.jpg","", new PVector(500,0));
        Planet saturn = new Planet("Saturn","Der Saturn ist von der Sonne aus gesehen der sechste Planet des Sonnensystems und mit einem Äquatordurchmesser von etwa 120.500 Kilometern nach Jupiter der zweitgrößte.",
                100,10.44f,"gravityExperiment/saturn.jpg","",new PVector(501,-500));

        Planet uranus = new Planet("Uranus","Der Uranus ist von der Sonne aus mit einer durchschnittlichen Sonnenentfernung von 2,9 Milliarden Kilometern der siebte Planet im Sonnensystem und wird zu den äußeren, jupiterähnlichen Planeten gerechnet. Er wurde am 13. März 1781 von Wilhelm Herschel entdeckt und ist nach dem griechischen Himmelsgott Uranos benannt.",
                100,8.87f,"gravityExperiment/uranus.jpg","",new PVector(1000,0));
        Planet neptune = new Planet("Neptun","Der Neptun ist der achte und äußerste bekannte Planet unseres Sonnensystems. Er wurde 1846 aufgrund von Berechnungen aus Bahnstörungen des Uranus durch den französischen Mathematiker Urbain Le Verrier von dem deutschen Astronomen Johann Gottfried Galle entdeckt.",
                100,11.15f,"gravityExperiment/neptune.jpg","", new PVector(1001,-500));


        planets.add(mercury);
        planets.add(venus);
        planets.add(earth);
        planets.add(mars);
        planets.add(jupiter);
        planets.add(saturn);
        planets.add(uranus);
        planets.add(neptune);


    }


    public void setup() {
        MainActivity activity = (MainActivity) getActivity();
        System.out.println(activity);
        this.cameraUp();
        this.noStroke();
        this.sphereDetail(40);


        initPlanets();

        for (Planet planet :
                planets) {
            PShape shape = createShape(SPHERE, planet.getSize());
            shape.setTexture(loadImage(planet.getImagePlanet()));
            planet.setShape(shape);
        }

        this.sphere = createShape(SPHERE, 80);

        spehreLocation = new PVector(0,500,1000);
        mainActivity = (MainActivity) this.getActivity();
    }

    public void draw() {
        this.background(0);

        //Planeten anzeigen
        if (showPlanets) {

            for (Planet planet :
                    planets) {


                if (this.intersectsSphere(planet.getSize(), -planet.getLocation().x, 0)) {
                    System.out.println("Hit planet: " + planet.getName());
                    planet.getShape().setTint(color(255, 200, 200, 230));

                    if (mousePressed) {

                        showPlanets = false;
                        selectedPlanet = planet;
                        spehreLocation = new PVector(0,500,1000);
                    }

                } else {
                    // System.out.println("No hit earth");
                    planet.getShape().setTint(color(255));
                }
                this.shape(planet.getShape(),planet.getLocation().x,planet.getLocation().y);
            }


        }else{
            //Kugel laden
            this.shape(sphere,spehreLocation.x,spehreLocation.y,200.0f,200.0f);
            this.textSize(24);
            this.text(selectedPlanet.getDescription() + "Seine Gravitation beträgt: " + selectedPlanet.getGravity() + " m/s*s. Klicke auf den Knopf," +
                    " um die Gravitation zu sehen! Danach gelangst" +
                    " du automatisch wieder zurück zu den Planeten!",
                    400, 100, 400, 500);
            this.rotateY(10);
            double velocity = selectedPlanet.getGravity();
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

        //mainActivity.setSketch(new GravityExperiment());
        System.err.println("STOP AFTER");

    }

}
