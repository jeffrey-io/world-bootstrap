package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class ZeroFunctions extends VectorSourcePrintStream {

    public ZeroFunctions(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("zero_out_", s(k))) {
                println();
                tab();
                println("/** set the " + k + "-vector to the (0,0) */");
                println("public void zero_out_", s(k), "() {");
                tab();
                println(atX(k) + " = 0.0;");
                println(atY(k) + " = 0.0;");
                untab();
                println("}");
                untab();
            }
        }
        for (int k = 0; k < N; k++) {
            if (start("is_", s(k), "_zero")) {
                println();
                tab();
                println("/** is the " + k + "-vector the origin */");
                println("public boolean is_", s(k), "_zero() {");
                tab();
                println("if (Math.abs(", atX(k), ") < ZERO_LIMIT && Math.abs(", atY(k), ") < ZERO_LIMIT)");
                tab();
                println("return true;");
                untab();
                println("return false;");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeTest() {
        for (int k = 0; k < N; k++) {
            if (startTest("zero_" + k)) {
                createNewVector("x", N);
                for (int j = 0; j <= k; j++) {
                    println("x.set_", s(j), "(3,5);");
                    println("assertEquals(3, x.x_", s(j), ");");
                    println("assertEquals(5, x.y_", s(j), ");");
                }
                println("x.zero_out_", s(k), "();");
                for (int j = 0; j < k; j++) {
                    println("assertEquals(3, x.x_", s(j), ");");
                    println("assertEquals(5, x.y_", s(j), ");");
                    println("Assert.assertFalse(x.is_", s(j), "_zero());");
                }
                println("assertEquals(0, x.x_", s(k), ");");
                println("assertEquals(0, x.y_", s(k), ");");
                println("Assert.assertTrue(x.is_", s(k), "_zero());");
                endTest();
            }
        }
        for (int k = 0; k < N; k++) {
            if (startTest("is_zero_" + k)) {
                createNewVector("x", N);
                println("x.set_", s(k), "(3,5);");
                println("assertEquals(3, x.x_", s(k), ");");
                println("assertEquals(5, x.y_", s(k), ");");
                println("Assert.assertFalse(x.is_", s(k), "_zero());");

                println("x.set_", s(k), "(0,5);");
                println("assertEquals(0, x.x_", s(k), ");");
                println("assertEquals(5, x.y_", s(k), ");");
                println("Assert.assertFalse(x.is_", s(k), "_zero());");

                println("x.set_", s(k), "(3,0);");
                println("assertEquals(3, x.x_", s(k), ");");
                println("assertEquals(0, x.y_", s(k), ");");
                println("Assert.assertFalse(x.is_", s(k), "_zero());");

                println("x.set_", s(k), "(0,0);");
                println("assertEquals(0, x.x_", s(k), ");");
                println("assertEquals(0, x.y_", s(k), ");");
                println("Assert.assertTrue(x.is_", s(k), "_zero());");
                endTest();
            }
        }
    }

}
