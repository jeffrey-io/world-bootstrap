package io.jeffrey.vector.compiler;

import java.io.File;

import org.junit.Test;

public class VectorAlgebraFactoryTest {

    private void destroy(final File root) {
        for (final File f : root.listFiles()) {
            if (f.isDirectory()) {
                destroy(f);
            } else {
                f.delete();
            }
        }
        root.delete();
    }

    @Test
    public void testProduction() throws Exception {
        final File root = new File("/tmp/generated-vector-register-" + System.currentTimeMillis());
        final File src = new File(root, "src/main/java/io/jeffrey/vector");
        final File test = new File(root, "src/test/java/io/jeffrey/vector");
        root.mkdirs();
        src.mkdirs();
        test.mkdirs();
        VectorAlgebraFactory.make(root, 4);
        destroy(root);
    }
}
