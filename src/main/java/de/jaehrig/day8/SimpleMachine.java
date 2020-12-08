package de.jaehrig.day8;

import java.util.List;

public class SimpleMachine implements Machine<Void> {

    private final List<Instruction> instructions;
    int accumulator = 0;
    int instructionPointer = 0;


    SimpleMachine(List<? extends Instruction> instructions) {
        this.instructions = List.copyOf(instructions);
    }

    @Override
    public Void execute() {
        getInstruction().execute(this);
        return null;
    }

    @Override
    public Instruction getInstruction() {
        return instructions.get(instructionPointer);
    }

    public int getInstructionPointer() {
        return instructionPointer;
    }

    public int getAccumulator() {
        return accumulator;
    }
}
