package br.ifsp.edu.br;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckDeCartas {
    private ArrayList<Carta> deck;

    public DeckDeCartas() {
        this.deck = new ArrayList<>();
        List<String> suits = Carta.getValidSuits();
        List<String> faceNames = Carta.getValidFaceNames();

        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                deck.add(new Carta(suit,faceName));
            }
        }
    }

    /**
     * This method will shuffle the card objects
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    public Carta dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    
    public int getNumOfCards()
    {
        return deck.size();
    }
}