package io.jeffrey.vector.compiler.functions;

import io.jeffrey.vector.compiler.VectorSourcePrintStream;

import java.io.PrintStream;
import java.util.HashSet;

public class AngleFunctions extends VectorSourcePrintStream {

    public AngleFunctions(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
    }

    @Override
    protected void writeSource() {
        for (int k = 0; k < N; k++) {
            if (start("angle_", s(k))) {
                println();
                tab();
                println("/** return the angle (via atan2) of the ", s(k), " vector */");
                println("public double angle_", s(k), "() {");
                tab();
                println("return Math.atan2(", atY(k), ", ", atX(k), ");");
                untab();
                println("}");
                untab();
            }
        }
        for (int k = 0; k < N; k++) {
            if (start("setByAngle", "_", s(k))) {
                println();
                tab();
                println("/** set the ", s(k), " vector to the complex number corresponding to the given angle */");
                println("public void set_", s(k), "_by_angle(final double theta) {");
                tab();
                println(atX(k), " = Math.cos(theta);");
                println(atY(k), " = Math.sin(theta);");
                untab();
                println("}");
                untab();
            }
        }
    }

    @Override
    protected void writeTest() {
        for (int k = 0; k < N; k++) {
            if (startTest("angles_" + k)) {
                createNewVector("x", N);
                println("x.set_", s(k), "_by_angle(0.5);");
                println("assertEquals(", s(Math.cos(0.5)), ", x.x_", s(k), ");");
                println("assertEquals(", s(Math.sin(0.5)), ", x.y_", s(k), ");");
                println("x.set_", s(k), "_by_angle(1.5);");
                println("assertEquals(", s(Math.cos(1.5)), ", x.x_", s(k), ");");
                println("assertEquals(", s(Math.sin(1.5)), ", x.y_", s(k), ");");
                println("x.set_", s(k), "_by_angle(2.5);");
                println("assertEquals(", s(Math.cos(2.5)), ", x.x_", s(k), ");");
                println("assertEquals(", s(Math.sin(2.5)), ", x.y_", s(k), ");");

                println("double u, v;");
                println("for(double theta = 0; theta < 7; theta += 0.1) {");
                tab();
                println("x.set_", s(k), "_by_angle(theta);");
                println("double omega = x.angle_", s(k), "();");
                println("u = x.x_", s(k), ";");
                println("v = x.y_", s(k), ";");
                println("x.set_", s(k), "_by_angle(omega);");
                println("assertEquals(u, x.x_", s(k), ");");
                println("assertEquals(v, x.y_", s(k), ");");
                untab();
                println("}");
                endTest();
            }
        }
    }

}
