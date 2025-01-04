package br.ifsp.edu.br;

public class CartaMemoria extends Carta{
    private boolean matched;

    public CartaMemoria(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method returns true if the 2 MemoryCard objects
     * have the same suit and faceName
     */
    public boolean isSameCard(CartaMemoria otherCard)
    {
        return (this.getSuit().equals(otherCard.getSuit()) &&
                (this.getFaceName().equals(otherCard.getFaceName())));
    }
}
