package labs_examples.objects_classes_methods.labs.oop.D_flashcard.dao;

import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dto.Card;
import java.util.List;

public interface FlashCardDao {
    List<Card> getAllCards();
    Card addCard(int cardId, Card card);
    Card viewCard(int cardId);
    Card removeCard(int id);
}
