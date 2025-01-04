package br.ifsp.edu.br;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable {

    @FXML
    private Label acertosLabel;

    @FXML
    private Label tentativasLabel;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList<CartaMemoria> cardsInGame;

    private CartaMemoria firstCard, secondCard;
    private int numDeTentativas;
    private int numOfMatches;

    @FXML
    void recomecar() {
        firstCard=null;
        secondCard =null;

        DeckDeCartas deck = new DeckDeCartas();
        deck.shuffle();
        cardsInGame = new ArrayList<>();

        for (int i =0; i<imagesFlowPane.getChildren().size()/2; i++)
        {
            Carta cardDealt = deck.dealTopCard();
            cardsInGame.add(new CartaMemoria(cardDealt.getSuit(),cardDealt.getFaceName()));
            cardsInGame.add(new CartaMemoria(cardDealt.getSuit(),cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);
        flipAllCards();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        recomecar();
    }

    /**
     * This will add a number to each ImageView and set the image to be the back of a Card
     */
    private void initializeImageView()
    {
        for (int i=0; i<imagesFlowPane.getChildren().size();i++)
        {
            //"cast" the Node to be of type ImageView
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Carta.class.getResourceAsStream("resouces/br/ifsp/edu/br/interrogacao.png")));
            imageView.setUserData(i);

            //register a click listener
            imageView.setOnMouseClicked(event -> {
                flipCard((int) imageView.getUserData());
            });
        }
    }

    /**
     * This will show the back of all cards that are not matched
     */
    private void flipAllCards()
    {
        for (int i=0; i<cardsInGame.size();i++)
        {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            CartaMemoria carta = cardsInGame.get(i);

            if (carta.isMatched())
                imageView.setImage(carta.getImage());
            else
                imageView.setImage(carta.getBackOfCardImage());
        }
    }

    private void flipCard(int indexOfCard)
    {
        if (firstCard==null && secondCard==null)
            flipAllCards();

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (firstCard==null)
        {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        }
        else if (secondCard==null)
        {
            numDeTentativas++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    private void updateLabels()
    {
        acertosLabel.setText(Integer.toString(numOfMatches));
        tentativasLabel.setText(Integer.toString(numDeTentativas));
    }

    private void checkForMatch()
    {
        if (firstCard.isSameCard(secondCard))
        {
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard=null;
        secondCard=null;
    }
}