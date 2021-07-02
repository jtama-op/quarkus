package io.quarkus.resteasy.reactive.server.deployment;

import java.util.Objects;
import java.util.function.BiPredicate;

public class EndpointConfig {

    private String consumes;
    private String produces;
    private String endpoint;

    private static final BiPredicate<String, String> isEquivalentMimeType = (item1, item2) -> item1.equals("*")
            || item2.equals("*") || item1.equals(item2);

    public EndpointConfig(String consumes, String produces, String endpoint) {
        this.consumes = consumes != null ? consumes : "*";
        this.produces = produces != null ? produces : "*";
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return String.format("consumes %s, produces %s", consumes, produces);
    }

    public String toCompleteString() {
        return String.format("%s consumes %s, produces %s", endpoint, consumes, produces);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EndpointConfig that = (EndpointConfig) o;
        return consumes.equals(that.consumes) && produces.equals(that.produces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumes, produces);
    }
}
