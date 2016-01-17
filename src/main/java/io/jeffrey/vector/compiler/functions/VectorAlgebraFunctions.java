package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class VectorAlgebraFunctions extends VectorSourcePrintStream {
    public VectorAlgebraFunctions(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    private void writeBinaryOp(final String name, final String op, final String how, final String docName) {
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start(name, "_", s(j), "_", how, "_" + s(k))) {
                    println();
                    tab();
                    println("/** " + docName + " the " + k + " and " + j + " together and store the result to the " + k + " vector */");
                    println("public void ", name, "_", s(j), "_", how, "_" + s(k), "() {");
                    tab();
                    println(atX(k), " ", op, "= ", atX(j), ";");
                    println(atY(k), " ", op, "= ", atY(j), ";");
                    untab();
                    println("}");
                    untab();
                }
            }
        }
    }

    private void writeScalarOp(final String name, final String op, final String docName) {
        for (int k = 0; k < N; k++) {
            if (start(name, "_", s(k))) {
                println();
                tab();
                println("/** " + docName + " vector " + k + " by the given scalar */");
                println("public void ", name, "_", s(k), "_by(double s) {");
                tab();
                println(atX(k), " ", op, "= s;");
                println(atY(k), " ", op, "= s;");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeSource() {
        writeBinaryOp("add", "+", "to", "add");
        writeBinaryOp("sub", "-", "from", "subtract");
        writeScalarOp("mult", "*", "multiply");
        writeScalarOp("div", "/", "divide");
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (k == j) {
                    continue;
                }
                if (start("dot_", s(j), "_", s(k))) {
                    println();
                    tab();
                    println("/** return the dot product between the " + k + " and " + j + " vectors */");
                    println("public double ", "dot_", s(j), "_", s(k), "() {");
                    tab();
                    println("return ", atX(k), " * ", atX(j), " + ", atY(k), " * ", atY(j), ";");
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
                if (startTest("algebra_" + k + "_" + j)) {
                    createNewVector("x", N);
                    println("x.set_", s(j), "(1,2);");
                    println("x.set_", s(k), "(3,5);");
                    println("x.mult_", s(k), "_by(4);");
                    println("assertEquals(12, x.x_", s(k), ");");
                    println("assertEquals(20, x.y_", s(k), ");");
                    println("x.div_", s(k), "_by(2);");
                    println("assertEquals(6, x.x_", s(k), ");");
                    println("assertEquals(10, x.y_", s(k), ");");
                    println("x.add_", s(j), "_to_", s(k), "();");
                    println("assertEquals(7, x.x_", s(k), ");");
                    println("assertEquals(12, x.y_", s(k), ");");
                    println("x.sub_", s(j), "_from_", s(k), "();");
                    println("assertEquals(6, x.x_", s(k), ");");
                    println("assertEquals(10, x.y_", s(k), ");");
                    println("assertEquals(6+2*10,x.dot_", s(j), "_", s(k), "());");
                    println("x.set_", s(k), "(1,2);");
                    endTest();
                }
            }
        }
    }

}
