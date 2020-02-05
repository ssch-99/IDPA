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
    public String getImageFileName() {
        return "";
    }

    public void settings() {
        fullScreen(MONO);
    }

    public void setup() {
        this.vrActivity = ((MainActivity)this.getActivity());
        cameraUp();
    }

    public void calculate() {

    }

    public void draw() {
        background(140);
        sphere(300);
    }
}
