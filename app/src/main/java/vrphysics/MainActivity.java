package vrphysics;

import android.os.Bundle;

import java.util.HashMap;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.sketches.Menu;

public class MainActivity extends VRActivity {
    private HashMap<String, PApplet> experiments;
    private PApplet menu;
    private PApplet currentSketch;

    private void populateExperimentList() {
        // Instantiate and load experiments
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.experiments = new HashMap<>();
        this.menu = new Menu();
        this.currentSketch = this.menu;

        this.setSketch(this.currentSketch);
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
