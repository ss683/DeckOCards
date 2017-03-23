package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String suitNames[] = {"spade", "club", "diamond", "heart"};
        String faceNames[] = {"jack", "queen", "king", "ace"};
        boolean face;
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("How many cards of each suit?");
        int a = input.nextInt();
        System.out.println("How many different suits?");
        int b = input.nextInt();
        System.out.println("What is the highest card?");
        int c = input.nextInt();
        System.out.println("Lowest card?");
        int d = input.nextInt();
        System.out.println("Face Cards? (0 is yes, 1 is no)");
        int y = input.nextInt();
        if(y == 0) {
            face = true;
            n = 4;
        }
        else {
            face = false;
            n = 0;
        }
        System.out.println("How many extra jokers?");
        int g = input.nextInt();
        Main z = new Main();
        int uniqueCards = (n + ((c - d) + 1)) * a;
        int totalCards = ((n + ((c - d) + 1)) * a * b) + g;
        int noJoker = totalCards - g;
        String[] cardNumbers = new String[noJoker];
        String[] suits = new String[noJoker];
        z.suits(totalCards, noJoker, suitNames, uniqueCards, b, suits);
        z.cardNumbers(totalCards, noJoker, c, d, a, uniqueCards, face, faceNames, b, cardNumbers);
        int cards = 1;
        for(int t = 0; t < b; t++)
        {
            for(int w = 0; w < uniqueCards; w++)
            {
                System.out.println("Card #" + cards + ": " + cardNumbers[cards-1] + " of " + suits[cards-1]);
                cards++;
            }
        }
    }
    public String[] suits(int t, int n, String[] a, int u, int b, String [] suits)
    {
        int start;
        int start2;
        int incre = 0;
        for(start = 0; start < b; start++)
        {
            for(start2 = incre; start2 < incre + u; start2++)
            {
                suits[start2] = a[start];
            }
            incre = incre + u;
        }
        System.out.println(Arrays.toString(suits));
        return suits;
    }
    public String[] cardNumbers(int t, int n, int c, int d, int a, int u, boolean face, String[] faceNames, int b, String[] cardNumbers)
    {
        String[] uniqueCardNumbers = new String[u];
        int start;
        int start2;
        int start3;
        int increment;
        int count = 0;
        int max = c;
        int min = d;
        for(start = 0; start < a; start++) {
            for (increment = d; increment <= max; increment++) {
                uniqueCardNumbers[increment - d] = Integer.toString(increment);
            }
            if(face == true) {
                for (increment = 0; increment < 4; increment++)
                {
                    uniqueCardNumbers[(max - 1) + increment] = faceNames[increment];
                }
            }
        }
        for(start3 = 0; start3 < uniqueCardNumbers.length; start3++) {
            for (start = 0; start < a; start++) {
                for (start2 = 0; start2 < b; start2++) {
                    cardNumbers[count] = uniqueCardNumbers[start3];
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(cardNumbers));
        return cardNumbers;
    }
}