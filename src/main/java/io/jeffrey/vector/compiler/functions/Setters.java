package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class Setters extends VectorSourcePrintStream {

    public Setters(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("set", s(k))) {
                println();
                tab();
                println("/** set the " + k + "-vector to the given (x,y) */");
                println("public void set_", s(k), "(final double x, final double y) {");
                tab();
                println(atX(k), " = x;");
                println(atY(k), " = y;");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeTest() {
        for (int k = 0; k < N; k++) {
            if (startTest("set_" + k)) {
                createNewVector("x", N);
                println("x.set_", s(k), "(3,5);");
                println("assertEquals(3, x.x_", s(k), ");");
                println("assertEquals(5, x.y_", s(k), ");");
                for (int j = 0; j < k; j++) {
                    println("assertEquals(0, x.x_", s(j), ");");
                    println("assertEquals(0, x.y_", s(j), ");");
                }
                endTest();
            }
        }
    }

}
