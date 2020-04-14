package com.company.LeetCode;

import java.util.Scanner;

public class StrongPasswordChecker {

    private static int strongPasswordChecker(String s){ ;
        int requiredChanges = 0;
        // 1. at least 6 and at most 20 characters;
        if (s.length()<6){
            requiredChanges += 6 - s.length();
        }

        if (s.length() > 20){
            requiredChanges += (s.length() - 20);
        }

        if (s.length() >=6 && s.length()<=20){
            int upperCase, lowerCase, digits;
            digits = upperCase = lowerCase = 0;
            char passwordCharacters[] = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (Character.isUpperCase(passwordCharacters[i])){
                    upperCase ++ ;
                }

                if (Character.isLowerCase(passwordCharacters[i])){
                    lowerCase ++ ;
                }

                if (Character.isDigit(passwordCharacters[i])){
                    digits ++;
                }


            }

            if (upperCase == 0) requiredChanges += 1;
            if (lowerCase == 0) requiredChanges += 1;
            if (digits == 0) requiredChanges += 1;

            // 3. checking if there are 3 repeating characters

            int sameCharacterRepeating = 0;

            for (int i = 0; i < s.length() - 3; i++) {// aaa111
                if (passwordCharacters[i] == passwordCharacters[i+1] && passwordCharacters[i+1] == passwordCharacters[i+2]){
                    sameCharacterRepeating ++;
                }
            }

            System.out.println(sameCharacterRepeating);
            if (s.length() <= 8 && sameCharacterRepeating != 1)
            requiredChanges += sameCharacterRepeating;

            else requiredChanges += (sameCharacterRepeating - 1);


        }

        return requiredChanges;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        System.out.println(strongPasswordChecker(password));
    }
}
