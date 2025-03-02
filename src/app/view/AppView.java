package app.view;

import java.util.Scanner;

public class AppView {
    Scanner scanner = new Scanner(System.in);
    public void getOutput(String output) {
        System.out.println(output);
    }


    public void getMenu() {
        System.out.println("""
                Menu:
                1 - Check balance
                2 - Top up the card balance
                3 - withdraw money
                4 - get menu
                5 - get the card out
                """);
    }

    public String  getInput(String input){
        System.out.print(input);
        return scanner.nextLine();
    }
    public int getInputInt(String input){
        System.out.print(input);
        return scanner.nextInt();
    }

}
