package de.jaehrig.day8;

public class InstructionVisitor implements Instruction {

    boolean hasBeenExecuted = false;
    private final Instruction instruction;

    public InstructionVisitor(final Instruction instruction) {
        this.instruction = instruction;
    }

    @Override
    public int execute(final SimpleMachine machine) {
        hasBeenExecuted = true;
        return instruction.execute(machine);
    }

    @Override
    public Operation getOp() {
        return instruction.getOp();
    }

    @Override
    public int getArgument() {
        return instruction.getArgument();
    }

    boolean isHasBeenExecuted() {
        return hasBeenExecuted;
    }
}
