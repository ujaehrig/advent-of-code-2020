package de.jaehrig.day8;

import de.jaehrig.common.PuzzleException;

public class InstructionImpl implements Instruction {

    private final Operation op;
    private final int argument;

    InstructionImpl(String s) {
        String[] array = s.split(" ");
        op = Operation.valueOf(array[0].toUpperCase());
        argument = Integer.parseInt(array[1]);
    }

    InstructionImpl(Operation op, int argument) {
        this.op = op;
        this.argument = argument;

    }

    @Override
    public int execute(final SimpleMachine machine) {
        switch (op) {
            case ACC:
                machine.accumulator += argument;
                machine.instructionPointer++;
                break;
            case JMP:
                machine.instructionPointer += argument;
                break;
            case NOP:
                machine.instructionPointer++;
                break;
            default:
                throw new PuzzleException("Unknown operation");
        }
        return machine.instructionPointer;
    }

    public Operation getOp() {
        return op;
    }

    public int getArgument() {
        return argument;
    }
}
