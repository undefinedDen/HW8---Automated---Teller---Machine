package app.validator;

import app.exception.GetException;
import app.utils.Constants;

public class AppValidator {
    public void validateIsEmptyLine(String input) throws GetException {
        input.trim();
        if (input.isEmpty()) {
            throw new GetException(Constants.EMPTY_LINE);
        }
    }
    public void validateBalance(double moneySum, double balance) throws GetException{
        if(balance < moneySum){
            throw new GetException("Your balance lesly than sum, witch you want to withdraw." +
                    " Please, firstly top up tou balance");
        }

    }
}
