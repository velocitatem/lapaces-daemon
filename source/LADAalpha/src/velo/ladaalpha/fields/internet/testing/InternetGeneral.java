package velo.ladaalpha.fields.internet.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.internet.APIreq;
import velo.ladaalpha.fields.internet.HttpResponse;
import velo.ladaalpha.fields.internet.Internet;

import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Auto-generated Javadoc

/**
 * The Class InternetGeneral.
 */
class InternetGeneral {

    /**
     * Fetch.
     */
    @Test
    void fetch() {
        String o = Internet.fetch("http://ifconfig.io/ip");
        assertTrue(o.contains("."));
    }

    /**
     * Gets the.
     */
    @Test
    void GET() {
        String p = "http://dummy.restapiexample.com/api/v1/employee/49";
        HttpResponse res = APIreq.GET(p);
        //System.out.println(res);
        assertTrue(res.getResponseCode() == 200);
    }

    /**
     * Post.
     */
    @Test
    void POST() {
        String path = "http://dummy.restapiexample.com/api/v1/create";
        String params = "name=test&salary=1265&age=2";
        HttpResponse res = APIreq.POST(path, params);
        //System.out.println(res);
        assertTrue(res.getResponseCode() == 200);
    }

}
