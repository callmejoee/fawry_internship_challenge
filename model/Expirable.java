package model;

import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpirationDate();
    default boolean isExpired(){
        LocalDate today = LocalDate.now();
        LocalDate expiryDate = getExpirationDate();
        return today.isAfter(expiryDate);
    }
}
