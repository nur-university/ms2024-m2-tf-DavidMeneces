package bo.nur.sgp_pln.infrastructure.persistence;

public class InfraestructureException extends RuntimeException {

    public InfraestructureException(String message) {
        super(message);
    }

    public InfraestructureException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraestructureException(Throwable cause) {
        super(cause);
    }
}
