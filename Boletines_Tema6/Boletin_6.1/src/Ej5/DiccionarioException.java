package Ej5;

public class DiccionarioException extends Exception{

    public DiccionarioException() {
    }

    public DiccionarioException(String message) {
        super(message);
    }

    public DiccionarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiccionarioException(Throwable cause) {
        super(cause);
    }

    public DiccionarioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
