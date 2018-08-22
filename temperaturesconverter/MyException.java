package temperaturesconverter;

/**
 * @author Vik Tolstoi
 */
public class MyException extends Exception {

    private String message;

    MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
