package vrphysics;

import android.os.Bundle;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.sketches.VRSketch;

public class MainActivity extends VRActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PApplet sketch = new VRSketch();
        setSketch(sketch);
    }
}
