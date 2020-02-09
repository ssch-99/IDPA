package vrphysics.sketches.gravityExperiment;

import processing.core.PShape;
import processing.core.PVector;


public class Planet {

    private String name;
    private String description;
    private Float gravity;
    private String imagePlanet;
    private String imageGround;
    private PVector location;
    private PShape shape;
    private Integer size;

    public Planet(String name, String description,Integer size, Float gravity, String imagePlanet, String imageGround, PVector location) {
        this.name = name;
        this.description = description;
        this.gravity = gravity;
        this.imagePlanet = imagePlanet;
        this.imageGround = imageGround;
        this.location = location;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getGravity() {
        return gravity;
    }

    public void setGravity(Float gravity) {
        this.gravity = gravity;
    }

    public String getImagePlanet() {
        return imagePlanet;
    }

    public void setImagePlanet(String imagePlanet) {
        this.imagePlanet = imagePlanet;
    }

    public String getImageGround() {
        return imageGround;
    }

    public void setImageGround(String imageGround) {
        this.imageGround = imageGround;
    }

    public PVector getLocation() {
        return location;
    }

    public void setLocation(PVector location) {
        this.location = location;
    }

    public PShape getShape() {
        return shape;
    }

    public void setShape(PShape shape) {
        this.shape = shape;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
