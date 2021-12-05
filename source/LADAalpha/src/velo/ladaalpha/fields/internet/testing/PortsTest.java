package velo.ladaalpha.fields.internet.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.internet.Internet;

import java.util.ArrayList;
import java.util.Arrays;

// TODO: Auto-generated Javadoc

/**
 * The Class PortsTest.
 */
class PortsTest {

    /**
     * Test.
     */
    @Test
    void test() {
        ArrayList<Integer> l = Internet.scanPorts("10.0.1.101");
        System.out.println(Arrays.toString(l.toArray()));
    }

}
