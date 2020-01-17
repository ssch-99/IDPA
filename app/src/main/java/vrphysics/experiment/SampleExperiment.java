package vrphysics.experiment;

import vrphysics.controls.SimulationControls;

public class SampleExperiment implements ExperimentMetaData, SimulationControls {
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

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void exit() {

    }
}
