package validation;

import java.util.regex.Pattern;

import custom_exceptions.ValidationExceptions.ValidationException;
import data_objects.UserDTO;

class EmailValidator extends AbstractValidator{
     /*
     * Implementacja Ogniwa Validacji Email.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    @Override
    public void validate(UserDTO user) throws ValidationException{
        String email = user.email();
        if ((email == null) || (email == "")) {
            throw new ValidationException("Empty Post Code!");
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidationException("Wrong email: " + email);
        }

        this.nextValidator.validate(user);
    }
}
