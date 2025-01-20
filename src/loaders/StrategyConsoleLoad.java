package loaders;

import java.util.Scanner;
import data_objects.UserDTO;

public class StrategyConsoleLoad implements IStrategyDataLoad {
    /* Implementacja Strategii ładowania z Konsolii */
    public UserDTO loadUserData() {

        try (Scanner scanner = new Scanner(System.in)){

            System.out.print("Podaj email: ");
            String email = scanner.nextLine();
            
            System.out.print("Podaj phone: ");
            String phone = scanner.nextLine();

            System.out.print("Podaj post code(opcjonalnie): ");
            String postCode = scanner.nextLine();

            scanner.close();

            return new UserDTO(email, phone, postCode);
        } catch (Exception e) {
            throw e;
        }
    }
}
