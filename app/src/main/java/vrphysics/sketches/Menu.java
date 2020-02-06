package vrphysics.sketches;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
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
        fullScreen(MONO);
    }

    public void setup() {
        this.cameraUp();
        this.noStroke();
        this.createMenuItems();
    }

    public void calculate() {

    }

    public void draw() {
        this.background(255);
        this.pushMatrix();
        this.scale(1, -1);

        for (PShape p : this.menuItems) {
            shape(p);
        }

        this.popMatrix();
    }

    private void createMenuItems(){
        int offset = 0;

        // TODO: include z-axis and adjust shape locations
        for (ExperimentMetaData e : this.experiments) {
            PShape shape = createShape(RECT, 150 * offset, 0, 100, 100);
            this.menuItems.add(shape);

            PImage image = loadImage(e.getImageFilePath());

            if (image == null) {
                this.loadImage("default-thumbnail.png");
            }

            shape.setTexture(image);

            offset++;
        }
    }
}
