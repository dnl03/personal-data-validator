package custom_exceptions;


public class ValidationExceptions {

    public static class CreateValidatorException extends Exception {
        public CreateValidatorException(String message) {
            super(message);
        }


        public CreateValidatorException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    

    public static class ValidationException extends Exception{
        public ValidationException(String message) {
            super(message);
        }


        public ValidationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
