package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class Pythagorean extends VectorSourcePrintStream {

    public Pythagorean(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("length_", "_", s(k))) {
                println();
                tab();
                println("/** compute and return the length of vector " + k + " */");
                println("public double length_", s(k), "() {");
                tab();
                println("double d = 0.0;");
                println("d += ", atX(k), " * ", atX(k), ";");
                println("d += ", atY(k), " * ", atY(k), ";");
                println("return Math.sqrt(d);");
                untab();
                println("}");
                untab();
            }
        }
        for (int k = 0; k < N; k++) {
            if (start("normalize_", "_", s(k))) {
                println();
                tab();
                println("/** normalize the " + k + "-vector if it is not the origin */");
                println("public boolean normalize_", s(k), "() {");
                tab();
                println("double d = 0.0;");
                println("d += ", atX(k), " * ", atX(k), ";");
                println("d += ", atY(k), " * ", atY(k), ";");
                println("if (Math.abs(d) < ZERO_LIMIT)");
                tab();
                println("return false;");
                untab();
                println("d = Math.sqrt(d);");
                println("d = 1.0 / d;");
                println(atX(k), " *= d;");
                println(atY(k), " *= d;");
                println("return true;");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeTest() {
        for (int k = 0; k < N; k++) {
            if (startTest("pythagorean_" + k)) {
                createNewVector("x", N);
                println("x.set_", s(k), "(3,5);");
                println("assertEquals(Math.sqrt(3*3+5*5), x.length_", s(k), "());");
                println("Assert.assertTrue(x.normalize_", s(k), "());");
                println("assertEquals(1, x.length_", s(k), "());");
                println("assertEquals(3/Math.sqrt(3*3+5*5), x.x_", s(k), ");");
                println("assertEquals(5/Math.sqrt(3*3+5*5), x.y_", s(k), ");");
                println("x.set_", s(k), "(0,0);");
                println("Assert.assertFalse(x.normalize_", s(k), "());");

                endTest();
            }
        }
    }

}
