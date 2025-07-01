package dao;

import dto.Card;
import java.util.List;

public interface FlashCardDao {
    List<Card> getAllCards() throws FlashCardDaoException;
    Card addCard(int cardId, Card card) throws FlashCardDaoException;
    Card viewCard(int cardId) throws FlashCardDaoException;
    Card removeCard(int id) throws FlashCardDaoException;
}
