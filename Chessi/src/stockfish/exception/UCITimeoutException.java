package stockfish.exception;

public class UCITimeoutException extends UCIRuntimeException {
    public UCITimeoutException(Throwable cause) {
        super(cause);
    }
}
