package com.xformation.foodordering.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mikolaj on 2015-11-19.
 */
public class Waiter {
    private int listIterator;

    public void askYesNoQuestion(String message){
        List<String> options = new ArrayList<>();
        options.add("Yes");
        options.add("No");
        askQuestion(message, options);
    }

    public void askQuestion(String message, List toChoose){
        printQuestion(message, toChoose);
    }

    private void printQuestion(String message, List toChoose){
        System.out.println(message);
        printOptions(toChoose);
    }

    private void printOptions(List toChoose) {
        listIterator = 1;
        toChoose.stream()
                .map(option -> String.valueOf(listIterator++) + " " + option.toString())
                .forEach(System.out::println);
    }

    public Integer takeAnswer() {
        int diffBetweenDisplayedOrderAndListOrder = 1;
        String key = takeStringAnswer();
        if (key.matches("\\d+")){
            return (Integer.parseInt(key) - diffBetweenDisplayedOrderAndListOrder);
        } else {
            return -1;
        }
    }

    public String takeStringAnswer(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
