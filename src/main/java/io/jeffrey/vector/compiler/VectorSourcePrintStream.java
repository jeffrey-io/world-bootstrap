package io.jeffrey.vector.compiler;

import java.io.PrintStream;
import java.util.HashSet;

public abstract class VectorSourcePrintStream {
    protected static final String TAB = "    ";

    public static final String hexify(final int X) {
        return Integer.toHexString(X).toUpperCase();
    }

    private final HashSet<String> definedFunctions;
    protected final int           N;
    private final PrintStream     output;

    private int                   tabbing;

    public VectorSourcePrintStream(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        output = out;
        this.N = N;
        tabbing = 0;
        this.definedFunctions = definedFunctions;
    }

    protected String atX(final int k) {
        return "x_" + k;
    }

    protected String atY(final int k) {
        return "y_" + k;
    }

    protected void createNewVector(final String name, final int k) {
        println("final VectorRegister", hexify(k), " ", name, " = new VectorRegister", hexify(k), "();");
    }

    protected void endTest() {
        untab();
        println("}");
        untab();
    }

    protected void println(final String... values) {
        if (values.length == 0) {
            output.println();
            return;
        }
        for (int k = 0; k < tabbing; k++) {
            output.print(TAB);
        }
        for (final String value : values) {
            output.print(value);
        }
        output.println();
    }

    protected String s(final double x) {
        return Double.toString(x);
    }

    protected String s(final int x) {
        return Integer.toString(x);
    }

    protected boolean start(final String... functionNameParts) {
        final StringBuilder fn = new StringBuilder();
        for (final String p : functionNameParts) {
            fn.append(p);
        }
        final String functionName = fn.toString();
        if (definedFunctions.contains(functionName)) {
            return false;
        }
        definedFunctions.add(functionName);
        return true;
    }

    protected boolean startTest(final String name) {
        if (start(name)) {
            tab();
            println();
            println("@Test");
            println("public void test", name.toUpperCase(), "() throws Exception {");
            tab();
            return true;
        }
        return false;
    }

    protected void tab() {
        tabbing++;
    }

    protected void untab() {
        tabbing--;
    }

    protected abstract void writeSource();

    protected abstract void writeTest();

}
