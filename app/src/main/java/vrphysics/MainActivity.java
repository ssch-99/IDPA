package vrphysics;

import android.os.Bundle;

import java.util.HashMap;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.sketches.Menu;
import vrphysics.sketches.GravityExperiment;
import vrphysics.sketches.SampleExperiment;

public class MainActivity extends VRActivity {
    private HashMap<String, PApplet> experiments;
    private PApplet menu;
    private PApplet currentSketch;

    private void populateExperimentList() {
        this.experiments.put("SampleExperiment", new SampleExperiment());
        this.experiments.put("GravityExperiment", new GravityExperiment());
    }

    private void testLoad() {
        this.loadExperiment("GravityExperiment");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PApplet menu = new Menu();
        setSketch(menu);

        this.experiments = new HashMap<>();
        this.populateExperimentList();
        this.menu = new Menu();
        this.currentSketch = this.menu;

        this.setSketch(this.currentSketch);
        //this.testLoad();
    }

    public void loadExperiment(String experiment) {
        if (this.experiments.containsKey(experiment)) {
            this.currentSketch = this.experiments.get(experiment);
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
