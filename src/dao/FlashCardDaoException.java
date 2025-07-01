package dao;

public class FlashCardDaoException extends Exception {

    /**
     * The exception is not caused by some other exception
     * @param message
     */
    public FlashCardDaoException(String message) {
        super(message);
    }

    /**
     * The exception is caused by another exception in the underlying implementation
     * @param message
     * @param cause
     */
    public FlashCardDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
