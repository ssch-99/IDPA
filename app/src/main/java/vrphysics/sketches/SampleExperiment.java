package vrphysics.sketches;

import vrphysics.MainActivity;
import vrphysics.experiment.BaseExperiment;

public class SampleExperiment extends BaseExperiment {
    @Override
    public String getTitle() {
        return "SampleExperiment A";
    }

    @Override
    public String getDescription() {
        return "Some nice description";
    }

    @Override
    public String getImageFilePath() {
        return "sampleExperiment/thumbnail.png";
    }

    public void settings() {
        fullScreen(MONO);
    }

    public void setup() {
        this.cameraUp();
    }

    public void calculate() {

    }

    public void draw() {
        this.background(140);
        this.sphere(300);
    }
}
