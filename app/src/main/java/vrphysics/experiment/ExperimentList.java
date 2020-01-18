package vrphysics.experiment;

import java.util.ArrayList;

public class ExperimentList {
    ArrayList<BaseExperiment> experiment_list;

    public ArrayList<BaseExperiment> getList() {
        experiment_list = new ArrayList<>();
        BaseExperiment experiment1 = new SampleExperiment();
        experiment_list.add(experiment1);

        return experiment_list;
    }
}
