package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> parent1 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> parent2 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        Collections.shuffle(parent1);
        Collections.shuffle(parent2);

        int size = parent1.size();

        Random random = new Random();

        int num1 = random.nextInt(size-1);
        int num2 = random.nextInt(size);

        int sliceStart = Math.min(num1,num2);
        int sliceEnd = Math.max(num1,num2);

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

        System.out.println("sliced between " + (sliceStart + 1) + " and " + sliceEnd);

        System.out.println("parents: ");
        printChromosome(parent1);
        System.out.println("");
        printChromosome(parent2);

        System.out.println("\n");
        System.out.println("children: ");
        printChromosome(child1);
        System.out.println("");
        printChromosome(child2);
    }

    public static void printChromosome(ArrayList<Integer> chromosome){
        for (int allele : chromosome){
            System.out.print(Integer.toString(allele));
        }
    }
}


