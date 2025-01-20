package validation;
import data_objects.UserDTO;
import custom_exceptions.ValidationExceptions.ValidationException;


public abstract class AbstractValidator {   
    /*
    * Abstrakcyjna klasa bazowa dla Validatorów. Pozwala na definiowanie konktetnych 
    * Validatorów, wspólny interface umożliwia tworzenie Łańcucha odpowiedzialnośći.
    */ 
    protected AbstractValidator nextValidator;

    public void setValidator(AbstractValidator nextValidaotr){
        this.nextValidator = nextValidaotr;
    }

    abstract public void validate(UserDTO data) throws ValidationException;
}
