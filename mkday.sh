#!/usr/bin/env bash

if [ $# -ne 1 ] ; then
  echo "Usage: mkdir.sh day"
  exit 1
fi

DAY="$1"

test -d "src/main/java/de/jaehrig/day${DAY}" || mkdir "src/main/java/de/jaehrig/day${DAY}"
test -d "src/test/java/de/jaehrig/day${DAY}" || mkdir "src/test/java/de/jaehrig/day${DAY}"
test -d "src/main/resources/day${DAY}" || mkdir "src/main/resources/day${DAY}"

touch "src/main/resources/day${DAY}/input.txt"

test -f "src/test/java/de/jaehrig/day${DAY}/Day${DAY}Test.java" ||
cat > "src/test/java/de/jaehrig/day${DAY}/Day${DAY}Test.java" <<EOF
package de.jaehrig.day${DAY};

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day${DAY}Test {

    private Day${DAY} classUnderTest = new Day${DAY}();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of();

        // when
        String solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo("");
    }
}
EOF
git add "src/test/java/de/jaehrig/day${DAY}/Day${DAY}Test.java"

test -f "src/main/java/de/jaehrig/day${DAY}/Day${DAY}.java" ||
cat > "src/main/java/de/jaehrig/day${DAY}/Day${DAY}.java" <<EOF
package de.jaehrig.day${DAY};

import de.jaehrig.common.Puzzle;
import java.util.stream.Stream;

public class Day${DAY} implements Puzzle {

    @Override
    public String solve(final Stream<String> input) {
        return null;
    }
}
EOF
git add "src/main/java/de/jaehrig/day${DAY}/Day${DAY}.java"
