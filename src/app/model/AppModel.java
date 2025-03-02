package app.model;

import app.exception.GetException;
import app.utils.Constants;
import app.validator.AppValidator;
import app.view.AppView;

public class AppModel {
    AppView view = new AppView();
    AppValidator validate = new AppValidator();

    public boolean getInsertCard(String insertCard) throws GetException {
        boolean insert = false;
        insertCard = view.getInput("Insert your card" +
                "(input \"+\" if you inserted your card or \"-\" if you don`t insert your card): ");
        if (insertCard.trim().equals("+")) {
            insert = true;

        } else if (insertCard.trim().equals("-")) {
            insert = false;
        } else {
            view.getOutput("Undefined symbol");
        }
        try {
            validate.validateIsEmptyLine(insertCard);
        } catch (GetException e) {
            view.getOutput(Constants.EMPTY_LINE);
        }
        return insert;
    }

    public double showBalance() {
        return 10000;
    }

    public int getChoice(String input) {
        int number = 0;
        boolean isChoice = false;
        while (!isChoice) {
            input = view.getInput("Choose operation: ").trim();
            if (input.isEmpty()) {
                view.getOutput(Constants.EMPTY_LINE);
                continue;
            }

            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                view.getOutput(Constants.NAN);
                continue;
            }
            if (number > 4 || number < 0) {
                view.getOutput("You can not input greater number than 4 and less number than 1! But you input: " + number);
                continue;
            }
            isChoice = true;
        }
        return number;
    }

    public double setTopUpSum() {
        double sum = 0;
        boolean isChoice = false;
        while (!isChoice) {
            String input = view.getInput("How much do you want to top up balance? ");
            if (input.isEmpty()) {
                view.getOutput(Constants.EMPTY_LINE);
                continue;
            }

            try {
                sum = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                view.getOutput(Constants.NAN);
                continue;
            }
            if (sum < 0 || sum == 0) {
                view.getOutput(Constants.NEGATIVE_SUM);
                continue;
            }
            isChoice = true;
        }
        return sum;
    }


    public double setWithdrawMoney() {
        double sum = 0;
        boolean isChoice = false;
        while (!isChoice) {
            String input = view.getInput("How much money do you want to withdraw? ");
            if (input.isEmpty()) {
                view.getOutput(Constants.EMPTY_LINE);
                continue;
            }
            try {
                sum = Double.parseDouble(input);
                validate.validateBalance(sum, showBalance());
            } catch (NumberFormatException e) {
                view.getOutput(Constants.NAN);
                continue;
            } catch (GetException e) {
                view.getOutput("Your balance lesly than sum, witch you want to withdraw." +
                        "Please, firstly top up tou balance");
                continue;
            }
            if (sum < 0 || sum == 0) {
                view.getOutput(Constants.NEGATIVE_SUM);
                continue;
            }
            isChoice = true;
        }
        return sum;
    }
}
