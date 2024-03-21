package Examen_2021_2022.Excepciones;

public class MazoException extends Exception{

    public MazoException() {
    }

    public MazoException(String message) {
        super(message);
    }

    public MazoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MazoException(Throwable cause) {
        super(cause);
    }

    public MazoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
