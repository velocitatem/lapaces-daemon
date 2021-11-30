package velo.ladealpha.fields.services.testing;

import static org.junit.jupiter.api.Assertions.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class JSTesting.
 */
class JSTesting {

	/**
	 * Test.
	 */
	@Test
	void test()  {
		StringBuffer javascript = null;
        ScriptEngine runtime = null;

        try {
            runtime = new ScriptEngineManager().getEngineByName("javascript");
            javascript = new StringBuffer();

            javascript.append("1 + 1");

            double result = (Double) runtime.eval(javascript.toString());

            System.out.println("Result: " + result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
	}

}
