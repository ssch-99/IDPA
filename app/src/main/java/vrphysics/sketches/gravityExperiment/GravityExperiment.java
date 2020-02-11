package vrphysics.sketches.gravityExperiment;

import android.renderscript.ScriptIntrinsicYuvToRGB;

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

    Float velocity = 0.00f;
    Float time = 0f;

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
                100,3.7f,"gravityExperiment/mercury.jpg","",new PVector(-900,0));

        Planet venus = new Planet("Venus","Die Venus ist mit einer durchschnittlichen Sonnenentfernung von 108 Millionen Kilometern der zweitinnerste und mit einem Durchmesser von ca. 12.100 Kilometern der drittkleinste Planet des Sonnensystems.",
                101,8.87f,"gravityExperiment/venus.jpg","",new PVector(-600,0));

        Planet earth = new Planet("Erde","Die Erde ist der dichteste, fünftgrößte und der Sonne drittnächste Planet des Sonnensystems. Sie ist Ursprungsort und Heimat aller bekannten Lebewesen.",
                102,9.81f, "gravityExperiment/earth.jpg","",new PVector(-300, 0));

        Planet mars = new Planet("Mars","Der Mars ist, von der Sonne aus gezählt, der vierte Planet im Sonnensystem und der äußere Nachbar der Erde. Er zählt zu den erdähnlichen Planeten.",
                103,3.711f,"gravityExperiment/mars.jpg","",new PVector(0, 0));

        Planet jupiter = new Planet("Jupiter","Jupiter ist mit einem Äquatordurchmesser von rund 143.000 Kilometern der größte Planet des Sonnensystems.",
                104,24.79f,"gravityExperiment/jupiter.jpg","", new PVector(300,0));
        Planet saturn = new Planet("Saturn","Der Saturn ist von der Sonne aus gesehen der sechste Planet des Sonnensystems und mit einem Äquatordurchmesser von etwa 120.500 Kilometern nach Jupiter der zweitgrößte.",
                105,10.44f,"gravityExperiment/saturn.jpg","",new PVector(600,0));

        Planet uranus = new Planet("Uranus","Der Uranus ist von der Sonne aus mit einer durchschnittlichen Sonnenentfernung von 2,9 Milliarden Kilometern der siebte Planet im Sonnensystem und wird zu den äußeren, jupiterähnlichen Planeten gerechnet. Er wurde am 13. März 1781 von Wilhelm Herschel entdeckt und ist nach dem griechischen Himmelsgott Uranos benannt.",
                106,8.87f,"gravityExperiment/uranus.jpg","",new PVector(900,0));
        Planet neptune = new Planet("Neptun","Der Neptun ist der achte und äußerste bekannte Planet unseres Sonnensystems. Er wurde 1846 aufgrund von Berechnungen aus Bahnstörungen des Uranus durch den französischen Mathematiker Urbain Le Verrier von dem deutschen Astronomen Johann Gottfried Galle entdeckt.",
                107,11.15f,"gravityExperiment/neptune.jpg","", new PVector(1200,0));


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
            translate(-500, 0,-800);
            int count = 1;
            for (Planet planet :
                    planets) {


                if (this.intersectsSphere(planet.getSize(), -planet.getLocation().x, planet.getLocation().y)) {
                    System.out.println("Hit planet: " + planet.getName());
                    planet.getShape().setTint(color(255, 200, 200, 230));

                    if (mousePressed) {

                        showPlanets = false;
                        selectedPlanet = planet;
                        spehreLocation = new PVector(0,500,1000);
                        velocity = 0f;
                        time = 0f;
                    }

                } else {
                    // System.out.println("No hit earth");
                    planet.getShape().setTint(color(255));
                }
                this.shape(planet.getShape(),planet.getLocation().x,planet.getLocation().y);

                count += 1;
            }


        }else{
            //Kugel laden
            this.translate(0,0,-400);
            this.rotateY(-0.723599f);
            this.shape(sphere,spehreLocation.x,spehreLocation.y,200.0f,200.0f);
            this.textSize(30);
            this.text(selectedPlanet.getDescription() + "Seine Gravitation beträgt: " + selectedPlanet.getGravity() + " m/s*s. Klicke auf den Knopf," +
                    " um die Gravitation zu sehen! Danach gelangst" +
                    " du automatisch wieder zurück zu den Planeten!",
                    400, 100, 400, 500);
            this.rotateY(10);
            Float accelleration = selectedPlanet.getGravity() / 60; // Methode wird 60 mal pro Sekunde ausgeführt -> pixel pro sekunde * sekunde
            velocity = (accelleration * time);
            System.out.println(velocity);
            int count = 1;
            if(start){
                if(this.spehreLocation.y > -700) {


                    this.spehreLocation.y -= velocity;

                        //this.delay(1);
                        time += (1);


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
        this.fullScreen(VR);
    }


    public void mousePressed(){

        if(!showPlanets){
            start = true;
        }
    }

    public void stop() {
        System.err.println("STOP");
       /* MainActivity mainActivity = (MainActivity) this.getActivity();
        mainActivity.setSketch(new GravityExperiment());*/
        this.exit();
        System.err.println("FINISHED");


    }

}
