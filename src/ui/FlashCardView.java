package labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui;

import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dto.Card;
import java.util.List;

public class FlashCardView {

    private final UserIO io;

    public FlashCardView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Cards");
        io.print("2. Add New Card");
        io.print("3. View Card");
        io.print("4. Remove Card");
        io.print("5. Exit");

        return io.readInt("Please enter a selection", 1, 5);
    }

    public void displayAllCardsBanner() {
        io.print("=== Display All Cards ===");
    }

    public void displayAllCards(List<Card> cards) {
        for (Card card : cards) {
            String cardInfo = String.format("#%d Q: %s A: %s",
                    card.getId(),
                    card.getFront(),
                    card.getBack());
            io.print(cardInfo);
        }
        io.print("Please hit enter to continue");
    }

    public Card getNewCard() {
        Card card = new Card();
        card.setFront(io.readString("Please enter the card's front (question or prompt)"));
        card.setBack(io.readString("Please enter the card's back (answer or response"));
        return card;
    }

    public void displayAddCardBanner() {
        io.print("=== Add Card ===");
    }

    public void displayAddCardSuccessBanner() {
        io.readString("Card successfully created. Please hit enter to continue");
    }

    public int getCardIdChoice() {
        return io.readInt("Please enter the Card ID");
    }

    public void displayCard(Card card) {
        if (card != null) {
            io.print(card.toString());
            io.print("");
        } else {
            io.print("No such card!");
        }
        io.print("Please hit enter to continue");
    }

    public void displayViewCardBanner() {
        io.print("=== Display Card ===");
    }

    public void removeCard(Card card) {
        if (card != null) {
            io.print("Card successfully removed");
        } else {
            io.print("No such card!");
        }
        io.print("Please hit enter to continue");
    }

    public void displayRemoveCardBanner() {
        io.print("=== Remove Card");
    }

    public void displayUnknownSelection() {
        io.print("Invalid Selection!");
    }

    public void displayExitBanner() {
        io.print("Good Bye!");
    }

    public void close() {
        io.close();
    }
}
