package com.sg.foundations.flowcontrol.methods;
import java.util.Random;

public class BarelyControlledChaos {
    public static void main(String[] args) {

        String color = pickColor();
        String animal = pickAnimal();
        String colorAgain = pickColor();
        int weight = pickNum(5, 200);
        int number = pickNum(10000, 20000);
        int distance = pickNum(10, 20);
        int time = pickNum(2, 6);

        System.out.println("Once when I was small");
        System.out.println("I was chased by a " + color + ", "
                + weight + " lb " + " miniature " + animal + " for over " +
                distance + " miles!");

        System.out.println("I had to hid in a field of over " + number +
                " " + colorAgain + " poppies for nearly " + time + " hours until it left me alone!");


        System.out.println("\n it was an experience " + "wubba lubba dub dub!");


    }

    public static String pickColor(){
        Random rand = new Random();
        String whatColor = " ";
        int colorPicker = rand.nextInt(5)+ 1;

        if (colorPicker == 1 ){
            whatColor = "blue";
        }
        if (colorPicker == 2 ){
            whatColor = "stallion black";
        }
        if (colorPicker == 3 ){
            whatColor = "falcon white";
        }
        if (colorPicker == 4 ){
            whatColor = "fire alarm red";
        }
        if (colorPicker == 5 ){
            whatColor = "emerald";
        }
        return  whatColor;

    }
    public static String pickAnimal(){
        Random rand = new Random();
        String whichAnimal = "";
        int animalPicker = rand.nextInt(5) + 1;

        if (animalPicker == 1 ){
            whichAnimal = "whale";
        }
        if (animalPicker == 2 ){
            whichAnimal = "sea lion";
        }
        if (animalPicker == 3 ){
            whichAnimal = "honey badger";
        }
        if (animalPicker == 4 ){
            whichAnimal = "fawn";
        }
        if (animalPicker == 5 ){
            whichAnimal = "tigress";
        }

        return whichAnimal;
    }
    public static int pickNum(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;


    }

}

