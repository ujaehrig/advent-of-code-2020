package de.jaehrig.day8;

import de.jaehrig.common.Puzzle;
import de.jaehrig.day8.SafeMachine.TerminationState;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day8Part2 implements Puzzle<Number> {

    @Override
    public Number solve(final Stream<String> input) {
        List<Instruction> masterInstructions = input
                .map(InstructionImpl::new)
                .collect(Collectors.toList());

        SafeMachine machine = null;
        for(int i = 0; i < masterInstructions.size(); ++i) {
            Instruction currentInstruction = masterInstructions.get(i);
            if (currentInstruction.getOp() == Operation.NOP || currentInstruction.getOp() == Operation.JMP) {
                List<Instruction> instructions = new ArrayList<>(masterInstructions);
                exchange(instructions, i);
                machine = new SafeMachine(instructions);
                TerminationState state = machine.runAll();
                if (state == TerminationState.OK) {
                    break;
                }
            }
        }

        return machine.getAccumulator();
    }

    private void exchange(final List<Instruction> instructions, final int i) {
        Instruction instruction = instructions.get(i);
        if (instruction.getOp() == Operation.JMP) {
            instructions.set(i, new InstructionImpl(Operation.NOP, instruction.getArgument()));
        } else if(instruction.getOp() == Operation.NOP) {
            instructions.set(i, new InstructionImpl(Operation.JMP, instruction.getArgument()));
        }
    }
}
