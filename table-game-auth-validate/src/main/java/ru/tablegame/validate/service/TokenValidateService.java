package ru.tablegame.validate.service;

import ru.tablegame.validate.model.MyAppClaims;

/**
 * @author nemykin 20.03.2021
 */
public interface TokenValidateService {

    /**
     * валидация токена
     *
     * @param token - зашифрованный токен
     * @return возврат строки
     */
    String validateToken(String token);

    /**
     * валидация токена
     *
     * @param claims - карточка с параметрами
     */
    void validateToken(MyAppClaims claims);

    /**
     * получение карточки из токена
     *
     * @param token - зашифрованный токен
     * @return - карточка юзера
     */
    MyAppClaims getAllClaimsFromToken(String token);
}
