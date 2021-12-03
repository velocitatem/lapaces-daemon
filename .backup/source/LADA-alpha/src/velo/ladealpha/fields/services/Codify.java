package velo.ladealpha.fields.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import velo.ladaalpha.fields.math.Equation;

import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


// TODO: Auto-generated Javadoc
/**
 * The Class Codify.
 */
public class Codify {	
	
	/**
	 * Compute string equation.
	 *
	 * @param equation the equation
	 * @param input the input
	 * @return the double
	 */
	public double computeStringEquation(String equation, double input) {		
        String classNameA = "FunctionR";
        RuntimeCompiler r = getCompiler(equation);
        Object o = MethodInvocationUtils.invokeStaticMethod(r.getCompiledClass(classNameA), "compute", ""+input);            
        return (double)o;
	}
	
	/**
	 * Gets the compiler.
	 *
	 * @param equation the equation
	 * @return the compiler
	 */
	public RuntimeCompiler getCompiler(String equation) {
		
        String classNameA = "FunctionR";
        String codeA =
            "public class FunctionR{" + "\n" + 
            "    public static double compute(String name) {" + "\n" +
            " 	 double x = Double.parseDouble(name);  \n " +
            "	 return " + equation + "; \n" + 
            "    }" + "\n" + 
            "}" + "\n";
            
        RuntimeCompiler r = new RuntimeCompiler();
        r.addClass(classNameA, codeA);
        r.compile();
        return r;
	}
	
}
