package com.epam.MentoringTask.Calculator;
import java.util.Scanner;
/**
 * Created by Sona_Gamaryan on 4/3/2017.
 */
public class Calculator {
    public static void main(String[] args){
        System.out.println("Task#1.1: Calculator");
        Scanner input = new Scanner(System.in);

        operations Maths = new operations();

        double answer = 0;
        double inputX, inputY;
        char operator;
        boolean done = false;

        while (done == false) {
            System.out.print("Please enter your 1st number: ");

            inputX = input.nextDouble();
            System.out.print("Please enter your operator: ");
            operator = input.next().charAt(0);
            System.out.print("Please enter your 2nd number: ");
            inputY = input.nextDouble();
            System.out.print("The result is ");
            switch (operator) {
                case '+':
                    answer = Maths.add(inputX, inputY);
                    break;
                case '-':
                    answer = Maths.subtract(inputX, inputY);
                    break;
                case '*':
                    answer = Maths.multiply(inputX, inputY);
                    break;
                case '/':
                    answer = Maths.divide(inputX, inputY);
                    break;
                case '%':
                    answer = Maths.modulus(inputX, inputY);
                    break;
            }

            System.out.println(answer);
        }

        input.close();

    }


    }

