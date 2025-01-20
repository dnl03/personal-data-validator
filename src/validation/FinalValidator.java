package validation;

import custom_exceptions.ValidationExceptions.ValidationException;
import data_objects.UserDTO;

class FinalValidator extends AbstractValidator {
    /*
     * Implementacja Ostatniego Ogniwa.
     */
    @Override
    public void validate(UserDTO user) throws ValidationException{
        if (this.nextValidator != null){
            throw new ValidationException("Final validator should be last validator");
        }
        System.err.println("All validations passed.");
    }
}
