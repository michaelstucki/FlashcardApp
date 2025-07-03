package dto;

public class Card {
    private int id;
    private String front;
    private String back;

    public Card() {}

    public Card(int id, String front, String back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
        return Integer.toString(id) + " : " + front + " : " + back;
    }
}
