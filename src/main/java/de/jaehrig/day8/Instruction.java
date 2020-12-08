package de.jaehrig.day8;

public interface Instruction {

    /**
     * execute an instruction
     *
     * @return the new instructionPointer
     */
    int execute(SimpleMachine machine);

    Operation getOp();

    int getArgument();
}
