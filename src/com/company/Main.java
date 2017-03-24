package com.company;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String faceNames[] = {"jack", "queen", "king", "ace"};
        boolean face = false;
        int n = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("How many cards of each suit?");
        int a = input.nextInt();
        System.out.println("How many different suits?");
        int b = input.nextInt();
        String suitNames[] = new String[b];
        for(int q = 0; q < b; q++){
            System.out.println("Name of suit #" + (q + 1) + "?");
            String nice = input.next();
            if(Arrays.asList(suitNames).contains(nice))
            {
                System.out.println("You have a suit with that identical name. Try again.");
                System.exit(0);
            }
            suitNames[q] = nice;
        }
        System.out.println("What is the highest card?");
        int c = input.nextInt();
        System.out.println("Lowest card?");
        int d = input.nextInt();
        if(d > c) {
            System.out.println("How can the lowest card be higher than the highest card? Try again.");
            System.exit(0);
        }
        System.out.println("Face Cards? (0 is yes, 1 is no)");
        int y = input.nextInt();
        if(y == 0) {
            face = true;
            n = 4;
        }
        else if(y == 1) {
            face = false;
            n = 0;
        }
        else {
            System.out.println("Didn't input 1 or 0. Try again.");
            System.exit(0);
        }
        int g = 0;
        System.out.println("Extra Cards? (0 is yes, 1 is no)");
        int w = input.nextInt();
        String exName = "";
        if(w == 0) {
            System.out.println("Name of extra card?");
            exName = input.next();
            if(face == true && (exName.equals("jack") || exName.equals("queen") || exName.equals("king") || exName.equals("ace")))
            {
                System.out.println("That is already a face card. Try again.");
                System.exit(0);
            }
            String[] numsPutIn = new String[(c-d) + 1];
            for(int w3 = d; w3 <= c; w3++)
            {
                numsPutIn[w3 - d] = Integer.toString(w3);
            }
            if(Arrays.asList(numsPutIn).contains(exName))
            {
                System.out.println("That is already a number card. Try again.");
                System.exit(0);
            }
            System.out.println("How many " + exName + "'s?");
            g = input.nextInt();
        }
        else if(w == 1) {
            g = 0;
        }
        else {
            System.out.println("Didn't input 1 or 0. Try again.");
            System.exit(0);
        }
        Main z = new Main();
        int uniqueCards = (n + ((c - d) + 1)) * a;
        int totalCards = ((n + ((c - d) + 1)) * a * b) + g;
        int noJoker = totalCards - g;
        String[] cardNumbers = new String[noJoker];
        String[] suits = new String[noJoker];
        z.suits(totalCards, noJoker, suitNames, uniqueCards, b, suits);
        z.cardNumbers(totalCards, noJoker, c, d, a, uniqueCards, face, faceNames, b, cardNumbers, g);
        int cards = 1;
        int start4;
        String cardContent = "";
        ArrayList<String> Cards = new ArrayList();
        for(int t = 0; t < b; t++)
        {
            for(int w2 = 0; w2 < uniqueCards; w2++)
            {
                cardContent = "Card #" + cards + ": " + cardNumbers[cards-1] + " of " + suits[cards-1];
                Cards.add(cardContent);
                cards++;
            }
        }
        for(start4 = 0; start4 < g; start4++)
        {
            cardContent = "Card #" + cards + ": " + exName + " #" + (start4 + 1);
            Cards.add(cardContent);
            cards++;
        }
        ArrayList<String> copyOfCards = Cards;
        String cardDeck = Arrays.toString(Cards.toArray());
        System.out.println("Initial Deck:");
        for(int h = 0; h < Cards.size(); h++) {
            System.out.println(Cards.get(h));
        }
        ArrayList<String> shuffled = new ArrayList();
        shuffled = z.shuffle(Cards);
        String shuffledDeck = Arrays.toString(shuffled.toArray());
        System.out.println("\n" + "Shuffled Deck:");
        for(int v = 0; v < shuffled.size(); v++) {
            System.out.println(shuffled.get(v));
        }
    }

    public ArrayList<String> shuffle(ArrayList<String> c)
    {
        int counter = 0;
        int size = c.size();
        Random rand = new Random();
        ArrayList<String> shuffledCards = new ArrayList();
        while(counter < size)
        {
            int randNum = rand.nextInt(size);
            if(c.get(randNum) != null)
            {
                shuffledCards.add(c.get(randNum));
                c.set(randNum, null);
                counter++;
            }
        }

        return shuffledCards;
    }

    public String[] suits(int t, int n, String[] a, int u, int b, String [] suits)
    {
        int start;
        int strt = 0;
        int strt2;
        int start2;
        int start3;
        int incre = 0;
        for(start = 0; start < b; start++)
        {
            for(start2 = incre; start2 < incre + u; start2++)
            {
                suits[start2] = a[start];
            }
            incre = incre + u;
        }
        while(strt < n)
        {
            for(strt2 = 0; strt2 < b; strt2++)
            {
                suits[strt + strt2] = a[strt2];
            }
            strt = strt + b;
        }
        System.out.println(Arrays.toString(suits));
        return suits;
    }
    public String[] cardNumbers(int t, int n, int c, int d, int a, int u, boolean face, String[] faceNames, int b, String[] cardNumbers, int g)
    {
        String[] uniqueCardNumbers = new String[u];
        int start;
        int start2;
        int start3;
        int increment;
        int count = 0;
        int countero = 0;
        int max = c;
        int min = d;
        for(start = 0; start < a; start++) {
            for (increment = d; increment <= max; increment++) {
                uniqueCardNumbers[countero] = Integer.toString(increment);
                countero++;
            }
            if(face == true) {
                for (increment = 0; increment < 4; increment++)
                {
                    uniqueCardNumbers[countero] = faceNames[increment];
                    countero++;
                }
            }

        }
        for(start3 = 0; start3 < uniqueCardNumbers.length; start3++) {
                for (start2 = 0; start2 < b; start2++) {
                    cardNumbers[count] = uniqueCardNumbers[start3];
                    count++;
                }
        }
        return cardNumbers;
    }
}