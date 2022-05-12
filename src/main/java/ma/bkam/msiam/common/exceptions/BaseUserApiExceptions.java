package ma.bkam.msiam.common.exceptions;

public class BaseUserApiExceptions extends RuntimeException {

    private final int status;
    private final String message;



    public BaseUserApiExceptions(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
