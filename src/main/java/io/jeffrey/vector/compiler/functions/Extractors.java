package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class Extractors extends VectorSourcePrintStream {
    public Extractors(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("extract", s(k))) {
                println();
                tab();
                println("/** extract the " + k + "-vector into the given output array starting at the given offset */");
                println("public void extract_", s(k), "(final double[] output, final int offset) {");
                tab();
                println("output[offset + 0] = ", atX(k), ";");
                println("output[offset + 1] = ", atY(k), ";");
                untab();
                println("}");
                untab();
            }
        }
        for (int k = 0; k < N; k++) {
            if (start("inject", s(k))) {
                println();
                tab();
                println("/** inject the given input starting at the given offset into the " + k + "-vector */");
                println("public void inject_", s(k), "(final double[] input, final int offset) {");
                tab();
                println(atX(k), " = input[offset + 0];");
                println(atY(k), " = input[offset + 1];");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeTest() {
        for (int k = 0; k < N; k++) {
            if (startTest("extract_" + k)) {
                createNewVector("x", N);
                println("double[] data = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};");
                println("x.set_", s(k), "(-1,-2);");
                println("x.extract_", s(k), "(data, 0);");
                println("x.extract_", s(k), "(data, 5);");
                println("x.extract_", s(k), "(data, 8);");
                println("assertEquals(-1,data[0]);");
                println("assertEquals(-2,data[1]);");
                println("assertEquals(2,data[2]);");
                println("assertEquals(3,data[3]);");
                println("assertEquals(4,data[4]);");
                println("assertEquals(-1,data[5]);");
                println("assertEquals(-2,data[6]);");
                println("assertEquals(7,data[7]);");
                println("assertEquals(-1,data[8]);");
                println("assertEquals(-2,data[9]);");
                endTest();
            }
        }
        for (int k = 0; k < N; k++) {
            if (startTest("inject_" + k)) {
                createNewVector("x", N);
                println("double[] data = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};");
                println("x.inject_", s(k), "(data, 0);");
                println("assertEquals(0, x.x_", s(k), ");");
                println("assertEquals(1, x.y_", s(k), ");");
                println("x.inject_", s(k), "(data, 6);");
                println("assertEquals(6, x.x_", s(k), ");");
                println("assertEquals(7, x.y_", s(k), ");");
                println("x.inject_", s(k), "(data, 8);");
                println("assertEquals(8, x.x_", s(k), ");");
                println("assertEquals(9, x.y_", s(k), ");");
                endTest();
            }
        }
    }
}
