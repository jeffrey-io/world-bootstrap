package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class Copiers extends VectorSourcePrintStream {
    public Copiers(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("copy_from_", s(j), "_to_", s(k))) {
                    println();
                    tab();
                    println("/** copy the " + j + " vector into the " + k + " vector */");
                    println("public void copy_from_", s(j), "_to_", s(k), "() {");
                    tab();
                    println(atX(k), " = ", atX(j), ";");
                    println(atY(k), " = ", atY(j), ";");
                    untab();
                    println("}");
                    untab();
                }
            }
        }
    }

    @Override
    protected void writeTest() {

        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (j == k) {
                    continue;
                }
                if (startTest("copy_" + k + "_" + j)) {
                    createNewVector("x", N);
                    println("x.set_", s(k), "(3,5);");
                    println("x.set_", s(j), "(1,2);");
                    println("assertEquals(3, x.x_", s(k), ");");
                    println("assertEquals(5, x.y_", s(k), ");");
                    println("x.copy_from_", s(j), "_to_", s(k), "();");
                    println("assertEquals(1, x.x_", s(k), ");");
                    println("assertEquals(2, x.y_", s(k), ");");
                    endTest();
                }
            }
        }
    }
}
