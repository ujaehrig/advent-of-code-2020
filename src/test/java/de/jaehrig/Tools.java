package de.jaehrig;

import de.jaehrig.common.PuzzleException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Tools {
    private Tools() {
        // fo not instantiate
    }

    public static List<String> getResourceAsList(String resourceName) {
        try(Stream<String> stream = getResourceAsStream(resourceName)) {
            return stream.collect(Collectors.toList());
        }
    }

    public static Stream<String> getResourceAsStream(String resourceName) {
        URL resource = Tools.class.getResource(resourceName);

        try {
            @SuppressWarnings("java:S2095")
            BufferedReader rdr = new BufferedReader(new InputStreamReader(resource.openStream()));
            return rdr.lines().onClose(() -> {
                try {
                    rdr.close();
                } catch (IOException exc) {
                    throw new PuzzleException("Error during close", exc);
                }
            });
        } catch (IOException e) {
            throw new PuzzleException(e);
        }
    }
}
