package Ejercicio2.Excepcioness;

public class HospitalException extends Exception{

    public HospitalException() {
    }

    public HospitalException(String message) {
        super(message);
    }

    public HospitalException(String message, Throwable cause) {
        super(message, cause);
    }

    public HospitalException(Throwable cause) {
        super(cause);
    }

    public HospitalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
