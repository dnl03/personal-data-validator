package loaders;

import data_objects.UserDTO;


public interface IStrategyDataLoad {
    /*
     * Interface definiujący kongtrakt ładowania danych. Jest oparty na strategii.
     * Implementacje tego interfejsu dostarczają szczegóły metody ładowania danych
     * Wg określonych strategii.
     */
    abstract public UserDTO loadUserData();
}
