package validation;

import java.util.regex.Pattern;

import custom_exceptions.ValidationExceptions.ValidationException;
import data_objects.UserDTO;

class PhoneValidator extends AbstractValidator{
     /*
     * Implementacja Ogniwa Validacji Phone
     */
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+\\d{8,15}$");

    @Override
    public void validate(UserDTO user) throws ValidationException {
        String phone = user.phone();

        if ((phone == null) || (phone == "")){
            throw new ValidationException("Empty Phone number!");
        }

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new ValidationException("Wrong phone: " + phone);
        }
        this.nextValidator.validate(user);
    }
}