import java.util.*;
import java.lang.Math;

public class SimpleCaptcha {
    public static void main(String[] args) throws Exception {
        int minGenerateNumber = 0;
        int maxGenerateNumber = 100;
        int valuePromptVerifyCaptcha;
        String promptVerifyCaptcha;
        Scanner verifyCaptcha = new Scanner(System.in);

        //SimpleCaptcha generating number and verify an input from user
        while(true){
            int resultGenerateNumber1 = (int) (Math.random()*(maxGenerateNumber - minGenerateNumber + 1)+minGenerateNumber);
            int resultGenerateNumber2 = (int) (Math.random()*(maxGenerateNumber - minGenerateNumber + 1)+minGenerateNumber);
            int resultCaptcha = resultGenerateNumber1 + resultGenerateNumber2;
            try {
                System.out.printf("\nWhat's result of %s + %s : ",resultGenerateNumber1,resultGenerateNumber2);
                promptVerifyCaptcha = verifyCaptcha.next();
                valuePromptVerifyCaptcha = Integer.parseInt(promptVerifyCaptcha);
                if(valuePromptVerifyCaptcha == resultCaptcha){
                    System.out.println("Access Approved : You're a human!\n");
                    verifyCaptcha.close();
                    break;
                }
                else{
                    System.out.println("Oops, try again!");
                    continue;
                }
            } catch(NumberFormatException e){
                System.out.println("Please enter the result as an integer only!");
            }
        }
    }
}
