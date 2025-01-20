
import custom_exceptions.ValidationExceptions.CreateValidatorException;
import custom_exceptions.ValidationExceptions.ValidationException;
import validation.ValidatorFactoryMethod;
import validation.AbstractValidator;

import data_objects.*;
import loaders.*;

public class Main {
    /*Główna Klasa Aplikacj */
    public static void main(String[] args) {
        IStrategyDataLoad dataLoader = new StrategyConsoleLoad();
        UserDTO userData = dataLoader.loadUserData();

        try{
            // Tworzenie łańcucha odpowiedzialności
            AbstractValidator emailValidator = ValidatorFactoryMethod.getValidator("email");
            AbstractValidator phoneValidator = ValidatorFactoryMethod.getValidator("phone");
            AbstractValidator postcodeValidator = ValidatorFactoryMethod.getValidator("postcode");
            AbstractValidator finalValidator = ValidatorFactoryMethod.getValidator("final");
            
            emailValidator.setValidator(phoneValidator);
            phoneValidator.setValidator(postcodeValidator);
            postcodeValidator.setValidator(finalValidator);

            // Walidacja
            emailValidator.validate(userData);

        } catch (CreateValidatorException e) {
            System.out.println(e.getMessage());
        
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
