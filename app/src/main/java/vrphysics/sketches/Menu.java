package vrphysics.sketches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import processing.core.PVector;
import vrphysics.experiment.BaseExperiment;
import vrphysics.experiment.ExperimentMetaData;

public class Menu extends PApplet {
    private PImage bg;
    private List<BaseExperiment> experiments;
    private HashMap<BaseExperiment, PShape> menuItems;
    private PVector origin;
    private PVector direction;
    private PVector focusedVector;

    public Menu(List<BaseExperiment> experiments) {
        this.experiments = experiments;
        this.menuItems = new HashMap<BaseExperiment, PShape>();
    }

    public void settings() {
        fullScreen(MONO);
    }

    public void setup() {
        this.cameraUp();
        this.noStroke();
        this.createMenuItems();
        origin = new PVector(0,0);
        direction = new PVector(0,0);
    }

    public void calculate() {

    }

    public void draw() {
        this.background(255);
        int offset = 0;

        for (Map.Entry<BaseExperiment, PShape> e : this.menuItems.entrySet()) {
            this.pushMatrix();
            this.scale(1, -1);
            this.shape(e.getValue());
            this.popMatrix();

            this.textSize(32);
            this.fill(50, 50, 50);
            this.text(e.getKey().getTitle(), 300 * offset, -140);

            offset++;
        }

        this.focusedVector = intersectsPlane(origin, direction);
        if(this.focusedVector != null){
            highlightOnHover();
        }
    }

    private void highlightOnHover() {
        /*Stream<HashMap<BaseExperiment, PShape>> item = this.menuItems.entrySet().stream().filter(e ->
             e.getValue().getParam(0) ==
        )*/
        for (Map.Entry<BaseExperiment, PShape> e : this.menuItems.entrySet()) {
            //float experimentX = e.getValue().getParams()[0];
            //float experimentY = e.getValue().getParams()[1];

            if(IsRayOnMenuItem(e.getValue())){
                e.getValue().setTexture(loadImage("default-thumbnail.png"));
            }
        }
    }

    private boolean IsRayOnMenuItem(PShape sh){
        float leftX = sh.getVertex(3).x;
        float rightX = sh.getVertex(2).x;
        float topY = sh.getVertex(2).y;
        float bottomY = sh.getVertex(0).y;

        return this.focusedVector.x >= leftX && this.focusedVector.x <= rightX && this.focusedVector.y >= bottomY && this.focusedVector.y <= topY;
    }

    private void createMenuItems() {
        int offset = 0;

        // TODO: include z-axis and adjust shape locations
        for (ExperimentMetaData e : this.experiments) {
            PShape menuShape = createShape(RECT, 300 * offset, 0, 100, 100);
            this.menuItems.put((BaseExperiment) e, menuShape);

            PImage image = loadImage(e.getImageFilePath());

            if (image == null) {
                this.loadImage("default-thumbnail.png");
            }

            menuShape.setTexture(image);

            offset++;
        }
    }
}
