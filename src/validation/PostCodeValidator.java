package validation;

import java.util.regex.Pattern;

import custom_exceptions.ValidationExceptions.ValidationException;
import data_objects.UserDTO;

class PostCodeValidator extends AbstractValidator {
     /*
     * Implementacja Ogniwa Validacji PostCode
     */
    private static final Pattern POST_CODE_PATTERN = Pattern.compile("^\\d{2}-\\d{3}$");
    
    @Override
    public void validate(UserDTO user) throws ValidationException{
        String postCode = user.postCode();
        System.out.println();
        //Post Code is Optional
        if (!POST_CODE_PATTERN.matcher(postCode).matches()) {
            throw new ValidationException("Wrong post code: " + postCode);
        }

        this.nextValidator.validate(user);
    }
}
