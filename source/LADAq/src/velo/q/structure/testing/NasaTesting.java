package velo.q.structure.testing;

import org.junit.jupiter.api.Test;
import velo.q.structure.data.Nasa;

class NasaTesting {

    @Test
    void satimg() {
        Object o = Nasa.SatIMG().fetch(new Object[]{"32.5", "12.4", "2021-08-17", "0.3"});
        System.out.println(Nasa.SatIMG().stringify(o));
    }

}
