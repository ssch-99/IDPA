package vrphysics.sketches;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;
import vrphysics.experiment.ExperimentMetaData;

public class Menu extends PApplet {
    private PImage bg;
    private List<BaseExperiment> experiments;
    private List<PShape> menuItems;

    public Menu(List<BaseExperiment> experiments) {
        this.experiments = experiments;
        this.menuItems = new ArrayList<PShape>();
    }

    public void settings() {
        fullScreen(VR);
    }

    public void setup() {
        //cameraUp();
        this.createMenuItems();
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
        int offset = 0;

        // TODO: include z-axis and adjust shape locations
        for (ExperimentMetaData e : this.experiments) {
            PVector location = new PVector((displayWidth / 2 - 100) * offset, (displayHeight / 2 - 100), 0);
            PShape shape = createShape(RECT, location.x, location.y, 100, 100);
            PImage image = loadImage(e.getImageFilePath());

            if (image == null) {
                loadImage("default-thumbnail.png");
            }

            shape.setTexture(image);
            this.menuItems.add(shape);

            offset++;
        }
    }
}
