package vrphysics;

import android.os.Bundle;

import processing.vr.VRActivity;
import processing.core.PApplet;
import vrphysics.sketches.menu.Menu;

public class MainActivity extends VRActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PApplet menu = new Menu();
        setSketch(menu);
    }
}
