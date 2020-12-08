package de.jaehrig.day7;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BagParserTest {

    private BagParser classUnderTest = new BagParser();

    @Test
    void testParser() {
        // given


        // when
        Map<String, Bag> rules = classUnderTest
                .parseRule(List.of("light red bags contain 1 bright white bag, 2 muted yellow bags."));

        // then
        assertThat(rules).hasSize(3);
        assertThat(rules.get("light red").getContained()).hasSize(2);
    }
}
