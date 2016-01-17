package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class ComplexAlgebra extends VectorSourcePrintStream {
    public ComplexAlgebra(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("conjugate_", "_", s(k))) {
                println();
                tab();
                println("/** treat vector " + k + " as a complex number and conjugate it */");
                println("public void conjugate_", s(k), "() {");
                tab();
                println(atY(k), " *= -1;");
                untab();
                println("}");
                untab();
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("complex_mult_", "_", s(j), "_", s(k))) {
                    println();
                    tab();
                    println("/** multiply via complex numbers the " + k + " and " + j + " together and store the result to the " + k + " vector */");
                    println("public void complex_mult_", s(j), "_", s(k), "() {");
                    tab();
                    println("final double t = ", atX(k), " * ", atX(j), " - ", atY(k), " * ", atY(j), ";");
                    println(atY(k), " = ", atX(k), " * ", atY(j), " + ", atY(k), " * ", atX(j), ";");
                    println(atX(k), " = t;");
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
            if (startTest("complex_conj_" + k)) {
                createNewVector("x", N);
                println("x.set_", s(k), "(3,5);");
                println("assertEquals(3, x.x_", s(k), ");");
                println("assertEquals(5, x.y_", s(k), ");");
                println("x.conjugate_", s(k), "();");
                println("assertEquals(3, x.x_", s(k), ");");
                println("assertEquals(-5, x.y_", s(k), ");");
                endTest();
            }
        }

        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (j == k) {
                    continue;
                }
                if (startTest("complex_" + k + "_" + j)) {
                    createNewVector("x", N);
                    println("x.set_", s(k), "(3,5);");
                    println("x.set_", s(j), "(1,2);");
                    println("x.complex_mult_", s(j), "_", s(k), "();");
                    println("assertEquals(3-10, x.x_", s(k), ");");
                    println("assertEquals(5+6, x.y_", s(k), ");");
                    endTest();
                }
            }
        }
    }

}
