package labs_examples.objects_classes_methods.labs.oop.D_flashcard.controller;

import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dao.FlashCardDao;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dto.Card;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui.FlashCardView;
import java.util.List;

public class FlashCardController {
    private FlashCardView view;
    private FlashCardDao dao;

    public FlashCardController(FlashCardView view, FlashCardDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listCards();
                    break;
                case 2:
                    addCard();
                    break;
                case 3:
                    displayCard();
                    break;
                case 4:
                    removeCard();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    view.displayUnknownSelection();
            }
        }
        view.displayExitBanner();
        view.close();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listCards() {
        view.displayAllCardsBanner();
        List<Card> cards = dao.getAllCards();
        view.displayAllCards(cards);
    }

    private void addCard() {
        view.displayAddCardBanner();
        Card card = view.getNewCard();
        dao.addCard(card.getId(), card);
        view.displayAddCardSuccessBanner();
    }

    private void displayCard() {
        view.displayViewCardBanner();
        int id = view.getCardIdChoice();
        Card card = dao.viewCard(id);
        view.displayCard(card);
    }

    private void removeCard() {
        view.displayRemoveCardBanner();
        int id = view.getCardIdChoice();
        Card card = dao.removeCard(id);
        view.removeCard(card);
    }
}
