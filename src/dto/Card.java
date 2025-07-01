package labs_examples.objects_classes_methods.labs.oop.D_flashcard.dto;

public class Card {
    private static int nextCardId = 1;
    private final int cardId = nextCardId++;
    private String front;
    private String back;

    public int getId() { return cardId; }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    @Override
    public String toString() {
        return Integer.toString(cardId) + " : " + front + " : " + back;
    }
}
