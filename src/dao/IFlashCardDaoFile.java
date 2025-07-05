package dao;

import dto.Card;
import java.io.*;
import java.util.*;

public class IFlashCardDaoFile implements FlashCardDao {
    private enum Index {ID, FRONT, BACK};
    private static final String CARD_FILE = "src/files/flashcards.txt";
    private static final String DELIMITER = "::";
    private final Map<Integer, Card> cards = new HashMap<>();

    @Override
    public List<Card> getAllCards() throws FlashCardDaoException {
        loadCards();
        return new ArrayList<Card>(cards.values());
    }

    @Override
    public Card addCard(int id, Card card) throws FlashCardDaoException {
        loadCards();
        Card newCard = cards.put(id, card);
        writeCards();
        return newCard;
    }

    @Override
    public Card viewCard(int id) throws FlashCardDaoException {
        loadCards();
        return cards.get(id);
    }

    @Override
    public Card removeCard(int id) throws FlashCardDaoException {
        loadCards();
        Card cardToRemove = cards.remove(id);
        writeCards();
        return cardToRemove;
    }

    private Card unmarshalCard(String cardAsText) {
        String[] cardTokens = cardAsText.split(DELIMITER);
        int cardId = Integer.parseInt(cardTokens[Index.ID.ordinal()]);
        String front = cardTokens[Index.FRONT.ordinal()];
        String back = cardTokens[Index.BACK.ordinal()];
        return new Card(cardId, front, back);
    }

    private void loadCards() throws FlashCardDaoException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CARD_FILE))) {
            String record;
            Card card;
            while ((record = reader.readLine()) != null) {
                card = unmarshalCard(record);
                cards.put(card.getId(), card);
            }
        // Translate implementation-specific exception into an application-specific exception
        } catch (IOException e) {
            throw new FlashCardDaoException("*** Could not load cards into memory.", e);
        }
    }

    private String marshalCard(Card card) {
        String cardAsText = card.getId() + DELIMITER;
        cardAsText += card.getFront() + DELIMITER;
        cardAsText += card.getBack();
        return cardAsText;
    }

    private void writeCards() throws FlashCardDaoException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CARD_FILE))) {
            String cardAsText;
            List<Card> cardList = new ArrayList<>(cards.values());
            for (Card card : cardList) {
                cardAsText = marshalCard(card);
                writer.write(cardAsText);
                writer.newLine();
            }
          // Translate implementation-specific exception into an application-specific exception
        } catch (IOException e) {
            throw new FlashCardDaoException("Could not save student data.", e);
        }
    }

    @Override
    // TODO move into service layer (to handle business logic to enforce business rules)
    public boolean checkCardId(Card card) {
        return cards.containsKey(card.getId());
    }
}
