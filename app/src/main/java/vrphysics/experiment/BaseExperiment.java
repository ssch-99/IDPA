package vrphysics.experiment;

import processing.core.PApplet;
import vrphysics.MainActivity;
import vrphysics.controls.SimulationControls;
import processing.core.PApplet;

public abstract class BaseExperiment extends PApplet implements ExperimentMetaData, SimulationControls {
    protected final MainActivity vrActivity = ((MainActivity)this.getActivity());

    public final void exit() {
        this.vrActivity.returnToMenu();
    }
}
