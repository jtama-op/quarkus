package io.quarkus.resteasy.reactive.server.test.duplicate;

import org.assertj.core.api.Assertions;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;

public class DuplicateResourceDetectionTest {

    @RegisterExtension
    static QuarkusUnitTest runner = new QuarkusUnitTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(GreetingResource.class, GreetingResource2.class, GreetingResource3.class))
            .assertException(throwable -> Assertions.assertThat(throwable)
                    .hasMessageContaining("GET /hello-resteasy is declared by :")
                    .hasMessageContaining(
                            "io.quarkus.resteasy.reactive.server.test.duplicate.GreetingResource#helloGet consumes *, produces text/plain")
                    .hasMessageContaining(
                            "io.quarkus.resteasy.reactive.server.test.duplicate.GreetingResource2#helloGet consumes *, produces text/plain"));

    @Test
    public void dummy() {

    }
}
