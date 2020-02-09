package vrphysics;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.experiment.BaseExperiment;
import vrphysics.sketches.Menu;
import vrphysics.sketches.gravityExperiment.GravityExperiment;
import vrphysics.sketches.SampleExperiment;
import vrphysics.sketches.gravityExperiment.PlanetSelection;

public class MainActivity extends VRActivity {
    private List<BaseExperiment> experiments;
    private PApplet menu;
    private PApplet currentSketch;

    private void populateExperimentList() {
        this.experiments.add(new SampleExperiment());
        this.experiments.add(new GravityExperiment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.experiments = new ArrayList<BaseExperiment>();
        this.populateExperimentList();
        this.menu = new Menu(this.experiments);
        this.currentSketch = this.menu;

        //this.setSketch(this.currentSketch);

        //Experiment laden
        System.out.println(this.experiments);
        this.setSketch(new PlanetSelection());
    }

    public void loadExperiment(BaseExperiment experiment) {
        if (this.experiments.contains(experiment)) {
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
