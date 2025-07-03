package dao;

import dto.Card;
import java.util.List;

public interface FlashCardDao {
    List<Card> getAllCards() throws FlashCardDaoException;
    Card addCard(int id, Card card) throws FlashCardDaoException;
    Card viewCard(int id) throws FlashCardDaoException;
    Card removeCard(int id) throws FlashCardDaoException;
    boolean checkCardId(Card card);
}
