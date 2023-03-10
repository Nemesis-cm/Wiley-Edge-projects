package com.sg.foundations.flowcontrol.methods;

public class MatchWork {

    public static void main(String[] args) {
        System.out.println("Cart is before Horse alphabetically: " + comesBefore("cart", "Horse"));
        System.out.println("half of 42 =: " + halfOf( 42));
        System.out.println(" (short) Pi = " + pi());
        System.out.println("The first letter of Llama: " + firstLetter("Llama"));
        System.out.println(" 1337 x 1337 = " + times1337(1337));
    }
    public static double pi(){
        return 3.14;
    }
    public static int times1337(int x){
        return x * 1337;
    }
    public static double halfOf(double y){
        return y / 2;
    }
    public static String firstLetter(String word){
        return word.substring(0, 1);
    }
    public static boolean comesBefore(String a, String b){
        return a.compareToIgnoreCase(b) < 0;
    }
}
