package controller;

import dao.FlashCardDao;
import dao.FlashCardDaoException;
import dto.Card;
import ui.FlashCardView;
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
        try {
            while (keepGoing) {
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
        } catch (FlashCardDaoException e) {
            view.displayErrorMessage(e.getMessage());
        } finally {
            view.displayExitBanner();
            view.close();
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listCards() throws FlashCardDaoException {
        view.displayAllCardsBanner();
        List<Card> cards = dao.getAllCards();
        view.displayAllCards(cards);
    }

    private void addCard() throws FlashCardDaoException {
        view.displayAddCardBanner();
        Card card = view.getNewCard();
        dao.addCard(card.getId(), card);
        view.displayAddCardSuccessBanner();
    }

    private void displayCard() throws FlashCardDaoException {
        view.displayViewCardBanner();
        int id = view.getCardIdChoice();
        Card card = dao.viewCard(id);
        view.displayCard(card);
    }

    private void removeCard() throws FlashCardDaoException {
        view.displayRemoveCardBanner();
        int id = view.getCardIdChoice();
        Card card = dao.removeCard(id);
        view.removeCard(card);
    }
}
