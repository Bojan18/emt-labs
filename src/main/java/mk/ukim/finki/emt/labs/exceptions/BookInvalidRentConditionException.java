package mk.ukim.finki.emt.labs.exceptions;

import mk.ukim.finki.emt.labs.enumerations.Condition;

public class BookInvalidRentConditionException extends RuntimeException{
    public BookInvalidRentConditionException(String name) {
        super(String.format("%s cannot be rented because the condition is Damaged.", name));
    }
}
