package validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import custom_exceptions.ValidationExceptions.CreateValidatorException;

public class ValidatorFactoryMethod<T> {
    /*
     * Klasa realizująca wzorzec Fabryki. Odpowiada z adynamiczne tworzenie Validatorów.
     * Klasy Validatorów są rejestrowane w statycznym Bloku Klasy.
     */
    private static final HashMap<String, Class<? extends AbstractValidator>> VALIDATORS_MAP = new HashMap<>();

    static {
        VALIDATORS_MAP.put("email", EmailValidator.class);
        VALIDATORS_MAP.put("phone", PhoneValidator.class);
        VALIDATORS_MAP.put("postcode", PostCodeValidator.class);
        VALIDATORS_MAP.put("final", FinalValidator.class);
    }

    public static AbstractValidator getValidator(String validatorName) throws CreateValidatorException {

        try {
            Class<? extends AbstractValidator> clsValidator = VALIDATORS_MAP.get(validatorName);
            if (clsValidator == null){
                throw new CreateValidatorException(
                    "Validator: " + validatorName + " is not registered in the Factory"
                );
            }

            Constructor<? extends AbstractValidator> constructor = clsValidator.getDeclaredConstructor();
            return constructor.newInstance();

        } catch (NoSuchMethodException | InstantiationException | 
                IllegalAccessException | InvocationTargetException e) {

            throw new CreateValidatorException(
                "Error crearing validator for: " + validatorName, e
            );
        }
    }
}
