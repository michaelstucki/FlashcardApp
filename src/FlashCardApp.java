import controller.FlashCardController;
import dao.FlashCardDao;
import dao.IFlashCardDaoFile;
import ui.FlashCardView;
import ui.IUserIOConsole;
import ui.UserIO;

public class FlashCardApp {

    public static void main(String[] args) {
        UserIO io = new IUserIOConsole();                                       // console implementation of the UserIO interface
        FlashCardView view = new FlashCardView(io);                             // dependency inject io into viewer
        FlashCardDao dao = new IFlashCardDaoFile();                             // file implementation of the DAO interface
        FlashCardController controller = new FlashCardController(view, dao);    // dependency inject view, dao into controller
        controller.run();                                                       // kickoff app
    }
}
