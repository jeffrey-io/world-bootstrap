package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class MatrixAlgebra extends VectorSourcePrintStream {

    public MatrixAlgebra(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("writeMatrix", "_", s(k), "_", s(j))) {
                    println();
                    tab();
                    println("/** set the matrixed form by the ", s(k), " vector and ", s(j), " vector (by column) */");
                    println("public void set_matrix_", s(k), "_", s(j), "(double x0, double y0, double x1, double y1) {");
                    tab();
                    println(atX(k), " = x0;");
                    println(atY(k), " = y0;");
                    println(atX(j), " = x1;");
                    println(atY(j), " = y1;");
                    untab();
                    println("}");
                    untab();
                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int v = 0; v < N; v++) {
                    if (k == j || j == v || v == k) {
                        continue;
                    }
                    if (start("transform_" + v + "_by_" + k + "_" + j)) {
                        println();
                        tab();
                        println("/** transform the " + v + " vector by the matrixed formed by the " + k + " and " + j + " vectors as columns */");
                        println("public void transform_" + v + "_by_" + k + "_" + j + "() {");
                        tab();
                        println("final double t = ", atX(k), " * ", atX(v), " + ", atX(j), " * ", atY(v), ";");
                        println(atY(v), " = ", atY(k), " * ", atX(v), " + ", atY(j), " * ", atY(v), ";");
                        println(atX(v), " = t;");
                        untab();
                        println("}");
                        untab();
                    }
                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("det_" + k + "_" + j)) {
                    println();
                    tab();
                    println("/** find the determinate of the 2x2 matrix formed by vector " + k + " and vector " + j + " where the vectors are columns */");
                    println("public double det_" + k + "_" + j + "() {");
                    tab();
                    println("return ", atX(k), " * ", atY(j), " - ", atY(k), " * ", atX(j), ";");
                    untab();
                    println("}");
                    untab();
                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("invert_" + k + "_" + j)) {
                    println();
                    tab();
                    println("/** invert the 2x2 matrix formed by vector " + k + " and vector " + j + " where the vectors are columns */");
                    println("public boolean invert_" + k + "_" + j + "() {");
                    tab();
                    println("final double t = ", atX(k), ";");
                    println("double invdet = ", atX(k), " * ", atY(j), " - ", atY(k), " * ", atX(j), ";");
                    println("if (Math.abs(invdet) < ZERO_LIMIT)");
                    tab();
                    println("return false;");
                    untab();
                    println("invdet = 1.0 / invdet;");
                    println(atX(j), " *= -1 * invdet;");
                    println(atY(k), " *= -1 * invdet;");
                    println(atX(k), " = ", atY(j), " * invdet;");
                    println(atY(j), " = t * invdet;");
                    println("return true;");
                    untab();
                    println("}");
                    untab();
                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("transpose_" + k + "_" + j)) {
                    println();
                    tab();
                    println("/** transpose the matrix formed by vector " + k + " and vector " + j + " where the vectors are columns */");
                    println("public void transpose_" + k + "_" + j + "() {");
                    tab();
                    println("final double t = ", atY(k), ";");
                    println(atY(k), " = ", atX(j), ";");
                    println(atX(j), " = t;");
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
                if (startTest("matrix_" + k + "_" + j)) {
                    createNewVector("x", N);
                    println("x.set_matrix_", s(k), "_", s(j), "(1,3,2,4);");
                    println("assertEquals(1, x.x_", s(k), ");");
                    println("assertEquals(3, x.y_", s(k), ");");
                    println("assertEquals(2, x.x_", s(j), ");");
                    println("assertEquals(4, x.y_", s(j), ");");
                    println("assertEquals(1*4-2*3, x.det_", s(k), "_", s(j), "());");
                    println("assertEquals(-(1*4-2*3), x.det_", s(j), "_", s(k), "());");
                    for (int z = 0; z < N; z++) {
                        if (z == j || z == k) {
                            continue;
                        }
                        println("x.set_", s(z), "(-1,5);");
                        println("x.transform_", s(z), "_by_", s(k), "_", s(j), "();");
                        println("assertEquals(-1*1+5*2, x.x_", s(z), ");");
                        println("assertEquals(-1*3+5*4, x.y_", s(z), ");");
                    }
                    println("Assert.assertTrue(x.invert_", s(k), "_", s(j), "());");

                    println("assertEquals(-2, x.x_", s(k), ");");
                    println("assertEquals(1.5, x.y_", s(k), ");");
                    println("assertEquals(1, x.x_", s(j), ");");
                    println("assertEquals(-0.5, x.y_", s(j), ");");
                    println("x.transpose_", s(k), "_", s(j), "();");
                    println("assertEquals(-2, x.x_", s(k), ");");
                    println("assertEquals(1, x.y_", s(k), ");");
                    println("assertEquals(1.5, x.x_", s(j), ");");
                    println("assertEquals(-0.5, x.y_", s(j), ");");
                    println("x.set_matrix_", s(k), "_", s(j), "(1,2,1,2);");
                    println("Assert.assertFalse(x.invert_", s(k), "_", s(j), "());");
                    println("assertEquals(0, x.det_", s(k), "_", s(j), "());");
                    endTest();
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (j == k) {
                    continue;
                }
                for (int z = 0; z < N; z++) {
                    if (z == j || z == k) {
                        continue;
                    }
                    if (startTest("matrix_transform_" + k + "_" + j + "_" + z)) {
                        createNewVector("x", N);
                        println("x.set_matrix_", s(k), "_", s(j), "(1,3,2,4);");
                        println("assertEquals(1, x.x_", s(k), ");");
                        println("assertEquals(3, x.y_", s(k), ");");
                        println("assertEquals(2, x.x_", s(j), ");");
                        println("assertEquals(4, x.y_", s(j), ");");
                        println("x.set_", s(z), "(-1,5);");
                        println("x.transform_", s(z), "_by_", s(k), "_", s(j), "();");
                        println("assertEquals(-1*1+5*2, x.x_", s(z), ");");
                        println("assertEquals(-1*3+5*4, x.y_", s(z), ");");
                        endTest();
                    }
                }
            }
        }
    }

}
