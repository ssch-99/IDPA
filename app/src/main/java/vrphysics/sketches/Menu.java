package vrphysics.sketches;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;
import vrphysics.experiment.ExperimentMetaData;

public class Menu extends PApplet {
    PImage bg;
    private List<ExperimentMetaData> experiments;
    private List<PShape> menuItems;

    public void settings() {
        fullScreen(VR);
    }

    public void setup() {
        //cameraUp();
        createMenuItems();
        // bg = loadImage("bg.jpg");
        // bg.resize(displayWidth, displayHeight);
    }

    public void calculate() {

    }

    public void draw() {
        background(255);

        shape(menuItems.get(0));
        shape(menuItems.get(1));

        // TODO: Fix iteration over menu items (static atm)
        /*ListIterator iterator = menuItems.listIterator();

        while(iterator.hasNext()){
            shape(menuItems.get(iterator.nextIndex()));
        }*/
    }

    private void createMenuItems(){
        loadExperiments();
        ListIterator iterator = experiments.listIterator();
        menuItems = new ArrayList<>();

        // TODO: include z-axis and adjust shape locations
        while(iterator.hasNext()){
            BaseExperiment experiment = ((BaseExperiment) iterator.next());
            PVector location = new PVector((displayWidth/2 - 100) * iterator.nextIndex(), displayHeight/2 - 100, 0);//iterator.nextIndex() * 100, 0);
            PShape shape = createShape(RECT,location.x, location.y, 100, 100);

            //String imageFilePath = String.format("./" + experiment.getTitle().replace(" ", "") + experiment.getImageFilePath() + "/thumbnail");

            PImage image = loadImage(experiment.getImageFilePath());

            if(image == null){
                image = loadImage("default-thumbnail.png");
            }

            shape.setTexture(image);

            menuItems.add(shape);
        }
    }

    private void loadExperiments(){
        this.experiments = new ArrayList<>();
        this.experiments.add(new SampleExperiment());
        this.experiments.add(new GravityExperiment());
    }
}

