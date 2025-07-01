package labs_examples.objects_classes_methods.labs.oop.D_flashcard;

import labs_examples.objects_classes_methods.labs.oop.D_flashcard.controller.FlashCardController;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dao.FlashCardDao;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.dao.IFlashCardDaoFile;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui.FlashCardView;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui.IUserIOConsole;
import labs_examples.objects_classes_methods.labs.oop.D_flashcard.ui.UserIO;

public class FlashCardApp {

    public static void main(String[] args) {
        UserIO io = new IUserIOConsole();                                       // console implementation of the UserIO interface
        FlashCardView view = new FlashCardView(io);                             // dependency inject io into viewer
        FlashCardDao dao = new IFlashCardDaoFile();                             // file implementation of the DAO interface
        FlashCardController controller = new FlashCardController(view, dao);    // dependency inject view, dao into controller
        controller.run();                                                       // kickoff app
    }
}
