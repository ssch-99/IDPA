package vrphysics.sketches.menu;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;
import vrphysics.experiment.BaseExperiment;
import vrphysics.experiment.ExperimentList;
import vrphysics.experiment.ExperimentMetaData;

public class Menu extends PApplet {
    public ExperimentList experiments;
    PShape menu;
    int menuPositionX;
    int menuPositionY;
    int menuWidth;
    int menuHeight;

    public void setup() {
        experiments = new ExperimentList();
        experiments.loadExperiments();
        menuPositionX = 0;
        menuPositionY = 0;
        menuHeight = 300;
        menuWidth = 400;
        menu = getMenu();
    }
    public void settings() {
        fullScreen(VR);
    }

    public void draw() {
        background(80);
        directionalLight(204, 204, 204, 1, 1, -1);
        shape(menu);
    }

    private PShape getMenu(){
        menu = createShape(RECT, menuPositionX, menuPositionY, menuWidth, menuHeight);
        //menu.height = 300;//(height/4)*3;
        //menu.width = 400;//(width/4)*3;
        PImage texture;

        //load menu texture
        texture = loadImage("starsky.jpg");
        if(texture != null) {
            menu.setTexture(texture);
        } else{
            menu.setFill(color(255));
        }

        // draw for each experiment
/*        for (BaseExperiment experiment: experiments){
            PShape menuItem;
            PShape menuItemTitle;
            PShape menuITemDescription;

            String title = experiment.getTitle();
            String description = experiment.getDescription();
            String imageFileName = experiment.getImageFileName();

            PImage image;
            image = loadExperimentImage(imageFileName);

            menuItem = createShape();

            if(image != null) {
                menuItem.setTexture(image);
            }

            menuItemTitle = createShape();
            menuITemDescription = createShape();

            menuItem.addChild(menuItemTitle);
            menuItem.addChild(menuITemDescription);
            menu.addChild(menuItem);
        }*/

        return menu;
    }

    private PImage loadExperimentImage(String imageName){
        PImage image;
        image = loadImage(imageName);

        if(image == null){
            //load default image
        }

        return image;
    }
}
