package br.ifsp.edu.br;

import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.List;

public class Carta {
    private String suit;
    private String faceName;

    public Carta(String suit, String faceName) {
        setSuit(suit);
        setFaceName(faceName);
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getValidSuits()
    {
        return Arrays.asList("arara","baleia","cachorro","cavalo", "cobra", "elefante", "foca", "gato", "hamster", "leao", "Macaco", "ovelha");
    }

    
    //@param suit
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " inválido, precisa ser "+getValidSuits());
    }

    public String getFaceName() {
        return faceName;
    }

    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("imagem");
    }

    //@param faceName
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        if (getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " é válido, mas precisa ser "+getFaceName());
    }

    public String toString()
    {
        return faceName + " de " + suit;
    }


    public int getValue()
    {
        return getValidFaceNames().indexOf(faceName) + 2;
    }

    @SuppressWarnings("exports")
    public Image getImage()
    {
        String pathName = "resouces/br/ifsp/edu/br"+faceName+suit+".png";
        return new Image(Carta.class.getResourceAsStream(pathName));
    }

    @SuppressWarnings("exports")
    public Image getBackOfCardImage()
    {
        return new Image(Carta.class.getResourceAsStream("resources/br/ifsp/edu/br/interrogacao.png"));
    }
}