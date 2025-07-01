package labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui;

public interface UserIO {
    public void print(String msg);
    public int readInt(String prompt);
    public int readInt(String prompt, int min, int max);
    public String readString(String prompt);
    public void close();
}
