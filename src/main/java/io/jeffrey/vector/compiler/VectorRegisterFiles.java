package io.jeffrey.vector.compiler;

import io.jeffrey.vector.compiler.functions.AngleFunctions;
import io.jeffrey.vector.compiler.functions.ComplexAlgebra;
import io.jeffrey.vector.compiler.functions.Copiers;
import io.jeffrey.vector.compiler.functions.Extractors;
import io.jeffrey.vector.compiler.functions.MatrixAlgebra;
import io.jeffrey.vector.compiler.functions.Pythagorean;
import io.jeffrey.vector.compiler.functions.Setters;
import io.jeffrey.vector.compiler.functions.VectorAlgebraFunctions;
import io.jeffrey.vector.compiler.functions.ZeroFunctions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;

public class VectorRegisterFiles extends VectorSourcePrintStream {

    private final ArrayList<VectorSourcePrintStream> components;

    public VectorRegisterFiles(final PrintStream out, final int N, final HashSet<String> definedFunctions) {
        super(out, N, definedFunctions);
        components = new ArrayList<VectorSourcePrintStream>();
        components.add(new Setters(out, N, definedFunctions));
        components.add(new ZeroFunctions(out, N, definedFunctions));
        components.add(new Copiers(out, N, definedFunctions));
        components.add(new Extractors(out, N, definedFunctions));
        components.add(new AngleFunctions(out, N, definedFunctions));
        components.add(new VectorAlgebraFunctions(out, N, definedFunctions));
        components.add(new ComplexAlgebra(out, N, definedFunctions));
        components.add(new Pythagorean(out, N, definedFunctions));
        components.add(new MatrixAlgebra(out, N, definedFunctions));
    }

    @Override
    public void writeSource() {
        println("package io.jeffrey.vector;");
        println("");
        println("/** a register bank that contains ", s(N), " vectors along with all possible operations */");
        println("public class VectorRegister" + hexify(N) + (N > 1 ? " extends VectorRegister" + hexify(N - 1) : "") + " {");
        if (N == 1) {
            println(TAB + "public static final double ZERO_LIMIT = 1E-14;");
        }
        tab();
        for (int k = N - 1; k < N; k++) {
            if (N == 1) {
                println("public double                 " + atX(k) + ";");
                println("public double                 " + atY(k) + ";");
            } else {
                println("public double " + atX(k) + ";");
                println("public double " + atY(k) + ";");

            }
        }
        println();
        println("public VectorRegister", hexify(N), "() {");
        tab();
        for (int k = N == 2 ? 0 : N - 1; k < N; k++) {
            println(atX(k) + " = 0.0;");
            println(atY(k) + " = 0.0;");
        }
        untab();
        println("}");
        untab();
        for (final VectorSourcePrintStream vsps : components) {
            vsps.writeSource();
        }
        println("}");
    }

    @Override
    public void writeTest() {
        println("package io.jeffrey.vector;");
        println();
        println("import org.junit.Assert;");
        println("import org.junit.Test;");
        println();
        println("public class GeneratedVectorRegister" + hexify(N) + "Test extends CommonVectorTestingBase {");
        for (final VectorSourcePrintStream vsps : components) {
            vsps.writeTest();
        }
        println("}");
    }

}
