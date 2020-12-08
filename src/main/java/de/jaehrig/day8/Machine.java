package de.jaehrig.day8;

public interface Machine<T> {

    T execute();


    Instruction getInstruction();

    int getAccumulator();

}
