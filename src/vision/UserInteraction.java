package vision;

import java.util.Scanner;

public class UserInteraction {

    boolean showConsole = false;
    public UserInteraction() {
        super();
    }

    public int receiveInt(String message, int minValue, int maxValue) {
        return this.receiveInt(message, minValue, maxValue, "O número digitado não atende aos parametros, favor tentar novamente.");
    }

    public int receiveInt(String message, int minValue, int maxValue, String errorMessage) {
        boolean loop = false;
        int receivedInteger = -1;

        do {
            System.out.println(message);

            String stringInt = new Scanner(System.in).next();
            try {
                Integer.parseInt(stringInt);
                receivedInteger = Integer.parseInt(stringInt);
                if (receivedInteger >= minValue && receivedInteger <= maxValue) {
                    loop = false;
                } else {
                    loop = true;
                    this.showMessage(errorMessage);
                }
            } catch (NumberFormatException nfe) {
                this.showMessage("Por favor digite apenas numeros");
                loop = true;
            }

        } while(loop);

        return receivedInteger;
    }

    public String receiveString(String message) {
        System.out.println(message);
        return new Scanner(System.in).next();
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public void showConsole(String mensagem){
        System.out.printf(mensagem);
    }


}