package labs_examples.objects_classes_methods.labs.oop.D_flashcard.dao;

import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dto.Card;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IFlashCardDaoFile implements FlashCardDao {
    private final Map<Integer, Card> cards = new HashMap<>();

    @Override
    public List<Card> getAllCards() {
        return new ArrayList<Card>(cards.values());
    }

    @Override
    public Card addCard(int cardId, Card card) {
        return cards.put(cardId, card);
    }

    @Override
    public Card viewCard(int cardId) {
        return cards.get(cardId);
    }

    @Override
    public Card removeCard(int id) {
        return cards.remove(id);
    }
}
