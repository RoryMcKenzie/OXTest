package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> parent1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<Integer> parent2 = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1));

        int size = parent1.size();

        //To be replaced with random numbers in the future
        int sliceStart = 3;
        int sliceEnd = 7;

        ArrayList<Integer> child1 = new ArrayList<>();
        ArrayList<Integer> child2 = new ArrayList<>();

        child1.addAll(parent1.subList(sliceStart,sliceEnd));
        child2.addAll(parent2.subList(sliceStart,sliceEnd));

        int currentAlleleIndex = 0;
        int currentAlleleInParent1 = 0;
        int currentAlleleInParent2 = 0;

        for (int i = 0; i <= size; i++){
            currentAlleleIndex = (sliceEnd + i) % size;
            currentAlleleInParent1 = parent1.get(currentAlleleIndex);
            currentAlleleInParent2 = parent2.get(currentAlleleIndex);

            if(!child1.contains(currentAlleleInParent2)){
                child1.add(currentAlleleInParent2);
            }

            if(!child2.contains(currentAlleleInParent1)){
                child2.add(currentAlleleInParent1);
            }
        }

        Collections.rotate(child1,sliceStart);
        Collections.rotate(child2,sliceStart);
    }
}
