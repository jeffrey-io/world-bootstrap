package io.jeffrey.vector.compiler;

import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;

public class VectorAlgebraFactory {

    public static void main(final String[] args) throws Exception {
        final File self = new File("./src/main/java/io/jeffrey/vector/compiler/VectorAlgebraFactory.java");
        if (!self.exists()) {
            throw new Exception("This is a hacked tool that requires you to run local to the src dir");
        }
        make(new File("."), 15);
    }

    public static void make(final File root, final int N) throws Exception {
        final HashSet<String> definedFunctions = new HashSet<String>();
        for (int r = 1; r <= N; r++) {
            final PrintStream source = new PrintStream(new File(root, "src/main/java/io/jeffrey/vector/VectorRegister" + VectorSourcePrintStream.hexify(r) + ".java"));
            try {
                new VectorRegisterFiles(source, r, definedFunctions).writeSource();
                source.flush();
            } finally {
                source.close();
            }
            final PrintStream test = new PrintStream(new File(root, "src/test/java/io/jeffrey/vector/GeneratedVectorRegister" + VectorSourcePrintStream.hexify(r) + "Test.java"));
            try {
                new VectorRegisterFiles(test, r, definedFunctions).writeTest();
                test.flush();
            } finally {
                test.close();
            }
        }
    }
}
