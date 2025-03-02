package app.controller;

import app.model.AppModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.view.AppView;

public class AppController {
    static String choice;
    static double balance;
    static String insertCard;
    AppModel model = new AppModel();
    AppView view = new AppView();

    public void getOutput() {
        view.getOutput(Constants.START_MSG);
        balance = model.showBalance();
        boolean insert = false;
        while (!insert) {
            insert = model.getInsertCard(insertCard);
            if (insert) {
                view.getOutput(Constants.INSERTED_TRUE);

            } else {
                view.getOutput(Constants.INSERTED_FALSE);
            }
        }

        view.getMenu();
        //Menu:
        //1 - Check balance
        //2 - Top up the card balance
        //3 - withdraw money
        //4 - get menu
        //5 - get the card out

        while (insert) {
            int inputChoice = model.getChoice(choice);
            switch (inputChoice) {
                case 1 ->
                    view.getOutput(Constants.BALANCE_IS + Constants.CURRENCY +
                            " " + Rounder.getRound(model.showBalance()));
                case 2 -> {
                   double setTopUpSum = model.setTopUpSum();
                   balance += setTopUpSum;
                    view.getOutput(Constants.UPDATE_BALANCE + " " + Constants.CURRENCY +
                            " " + Rounder.getRound(balance));

                }
                case 3 ->{
                    double setWithdrawMoney = model.setWithdrawMoney();
                    balance -= setWithdrawMoney;
                    view.getOutput(Constants.UPDATE_BALANCE + " " + Constants.CURRENCY +
                        " " + Rounder.getRound(balance));
                }
                case 4 -> view.getMenu();
                case 5 -> {
                    view.getOutput(Constants.FINISH_MSG);
                    insert = false;
                }
                default -> view.getOutput("Input only \"1\" , \"2\" ,\"3\", \"4\", \"5\"!!! ");
            }
        }
    }
}

