package velo.q.structure.testing;

import org.junit.jupiter.api.Test;
import velo.q.structure.data.Cameras;

import java.util.ArrayList;

class CamerasTesting {

    @Test
    void test() {
        ArrayList<String> cameras = (ArrayList<String>) Cameras.getCamerasFor().fetch(new Object[]{"Berlin"});
        for (String cam : cameras) {
            System.out.println(cam);
        }
        System.out.println();
    }

}
