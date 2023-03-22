package mk.ukim.finki.emt.labs.exceptions;

import mk.ukim.finki.emt.labs.enumerations.RentalStatus;

public class BookAlreadyRentedException extends RuntimeException{
    public BookAlreadyRentedException(String name, RentalStatus rentalStatus) {
        super(String.format("%s cannot be rented and it's rental status is %s, every single copy is already rented.", name, rentalStatus.name()));
    }
}
