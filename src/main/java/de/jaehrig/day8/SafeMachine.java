package de.jaehrig.day8;

import de.jaehrig.day8.SafeMachine.TerminationState;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A machine checking if an instruction has already been
 * executed and terminating abnormally
 */
public class SafeMachine implements Machine<TerminationState> {

    enum TerminationState {
        OK, LOOP_DETECTED, INVALID
    }

    private final SimpleMachine machine;
    private final int programSize;

    public SafeMachine(List<? extends Instruction> instructions) {
        List<Instruction> collect = instructions.stream().map(InstructionVisitor::new).collect(Collectors.toList());
        programSize = collect.size();
        machine = new SimpleMachine(collect);
    }

    @Override
    public TerminationState execute() {
        InstructionVisitor instruction = (InstructionVisitor)getInstruction();
        if (instruction.hasBeenExecuted) {
            return TerminationState.LOOP_DETECTED;
        }
        executeInternally();
        return TerminationState.OK;
    }

    public TerminationState runAll() {
        while(machine.getInstructionPointer() < programSize) {
            TerminationState state = execute();
            if (state == TerminationState.LOOP_DETECTED) {
                return TerminationState.LOOP_DETECTED;
            }
        }
        return machine.getInstructionPointer() == programSize ? TerminationState.OK : TerminationState.INVALID;
    }

    private void executeInternally() {
        machine.execute();
    }

    @Override
    public Instruction getInstruction() {
        return machine.getInstruction();
    }

    @Override
    public int getAccumulator() {
        return machine.getAccumulator();
    }
}
