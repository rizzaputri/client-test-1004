package com.enigma.test_nawadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sort Character
        System.out.println("Input one line of words : ");
        String s = sc.nextLine();
        sortCharacter(s);

        // Social Restriction
        System.out.println("Input the number of families : ");
        int i = sc.nextInt();
        sc.nextLine();
        System.out.println("Input the number of members in the family : ");
        String n = sc.nextLine();
        socialRestriction(i, n);

        sc.close();
    }

    private static void sortCharacter(String s) {
        String string = s.replaceAll("\\s+", "").toLowerCase();
        List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> consonant = List.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');

        List<Character> vowels = new ArrayList<>();
        List<Character> consonants = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (vowel.contains(string.charAt(i))) {
                if (vowels.contains(string.charAt(i))) {
                    vowels.add(vowels.indexOf(string.charAt(i)) + 1, string.charAt(i));
                } else {
                    vowels.add(string.charAt(i));
                }
            } else if (consonant.contains(string.charAt(i))) {
                if (consonants.contains(string.charAt(i))) {
                    consonants.add(vowels.indexOf(string.charAt(i)) + 1, string.charAt(i));
                } else {
                    consonants.add(string.charAt(i));
                }
            }
        }

        System.out.println("Vowel Characters :");
        vowels.forEach(System.out::print);
        System.out.println();
        System.out.println("Consonant Characters :");
        consonants.forEach(System.out::print);
        System.out.println();
    }

    private static void socialRestriction(int i, String n) {
        String string = n.replaceAll("\\s+", "");

        List<Integer> integers = new ArrayList<>();
        for (int j = 0; j < string.length(); j++) {
            int integer = Integer.parseInt(String.valueOf(string.charAt(j)));
            integers.add(integer);
        }

        if (integers.size() == i) {
            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            int bus = (int) Math.ceil((double) sum / 4);
            System.out.println("Minimum bus required is : " + bus);
        } else {
            System.out.println("Input must be equal with count of family");
        }
    }
}
