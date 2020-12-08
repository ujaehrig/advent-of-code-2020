package de.jaehrig.day8;

import de.jaehrig.common.Puzzle;
import de.jaehrig.day8.SafeMachine.TerminationState;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day8 implements Puzzle<Number> {

    @Override
    public Number solve(final Stream<String> input) {
        List<Instruction> instructions = input
                .map(InstructionImpl::new)
                .collect(Collectors.toList());

        SafeMachine machine = new SafeMachine(instructions);

        TerminationState state = TerminationState.OK;
        while (state != TerminationState.LOOP_DETECTED) {
            state = machine.execute();
        }

        return machine.getAccumulator();
    }
}
