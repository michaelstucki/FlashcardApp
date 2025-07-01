package labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui;

import java.util.Scanner;

public class IUserIOConsole implements UserIO {
    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int result = 0;
        while(invalidInput) {
            try {
                String stringNum = readString(prompt);
                result = Integer.parseInt(stringNum);
                invalidInput = false;
            } catch (NumberFormatException e) {
                print("Input error. Please try again.");
            }
        }
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while(result < min || result > max);
        return result;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    @Override
    public void close() {
        console.close();
    }
}
