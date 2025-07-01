package dao;

import dto.Card;

import java.io.*;
import java.util.*;

public class IFlashCardDaoFile implements FlashCardDao {
    public static final String CARD_FILE = "flashcards.txt";
    public static final String DELIMITER = "::";

    private final Map<Integer, Card> cards = new HashMap<>();

    @Override
    public List<Card> getAllCards() throws FlashCardDaoException {
        loadCards();
        return new ArrayList<Card>(cards.values());
    }

    @Override
    public Card addCard(int cardId, Card card) throws FlashCardDaoException {
        loadCards();
        Card newCard = cards.put(cardId, card);
        writeCards();
        return newCard;
    }

    @Override
    public Card viewCard(int cardId) throws FlashCardDaoException {
        loadCards();
        return cards.get(cardId);
    }

    @Override
    public Card removeCard(int id) throws FlashCardDaoException {
        loadCards();
        Card cardToRemove = cards.remove(id);
        writeCards();
        return cardToRemove;
    }

    public Card unmarshalCard(String cardAsText) {
        String[] cardTokens = cardAsText.split(DELIMITER);
        int cardId = Integer.parseInt(cardTokens[0]);
        String front = cardTokens[1];
        String back = cardTokens[2];
        return new Card(cardId, front, back);
    }

    public void loadCards() throws FlashCardDaoException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(CARD_FILE)));
            String record;
            Card card;
            while (scanner.hasNextLine()) {
                record = scanner.nextLine();
                card = unmarshalCard(record);
                cards.put(card.getId(), card);
            }
        // Translate implementation-specific exception into an application-specific exception
        } catch (FileNotFoundException e) {
            throw new FlashCardDaoException("*** Could not load cards data into memory.", e);
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    public String marshalCard(Card card) {
        String cardAsText = card.getId() + DELIMITER;
        cardAsText += card.getFront() + DELIMITER;
        cardAsText += card.getBack();
        return cardAsText;
    }

    public void writeCards() throws FlashCardDaoException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(CARD_FILE));
            String cardAsText;
            List<Card> cardList = new ArrayList<>(cards.values());
            for (Card card : cardList) {
                cardAsText = marshalCard(card);
                out.println(cardAsText);
                out.flush();
            }
        // Translate implementation-specific exception into an application-specific exception
        } catch (IOException e) {
            throw new FlashCardDaoException("Could not save student data.", e);
        } finally {
            if (out != null) out.close();
        }
    }
}
