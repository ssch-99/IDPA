package vrphysics;

import android.os.Bundle;

import java.util.HashMap;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.experiment.BaseExperiment;
import vrphysics.sketches.Menu;
import vrphysics.sketches.GravityExperiment;
import vrphysics.sketches.SampleExperiment;

public class MainActivity extends VRActivity {
    private HashMap<String, BaseExperiment> experiments;
    private PApplet menu;
    private PApplet currentSketch;

    private void populateExperimentList() {
        this.experiments.put("SampleExperiment", new SampleExperiment());
        this.experiments.put("GravityExperiment", new GravityExperiment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.experiments = new HashMap<>();
        this.populateExperimentList();
        this.menu = new Menu(this.experiments.values());
        this.currentSketch = this.menu;

        this.setSketch(this.currentSketch);
    }

    public void loadExperiment(BaseExperiment experiment) {
        if (this.experiments.containsValue(experiment)) {
            this.currentSketch = experiment;
            this.setSketch(this.currentSketch);
        } else {
            this.returnToMenu();
        }
    }

    public void returnToMenu() {
        this.currentSketch = this.menu;
        this.setSketch(this.currentSketch);
    }
}
