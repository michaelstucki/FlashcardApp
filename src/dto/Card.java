package dto;

public class Card {
    private static int nextCardId = 1;
    private int cardId = nextCardId++;
    private String front;
    private String back;

    public Card() {}

    public Card(int cardId, String front, String back) {
        this.cardId = cardId;
        this.front = front;
        this.back = back;
    }

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
