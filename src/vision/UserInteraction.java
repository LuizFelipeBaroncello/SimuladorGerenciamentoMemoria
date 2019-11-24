package vision;

import javax.swing.JOptionPane;

public class UserInteraction {

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
            String stringInt = JOptionPane.showInputDialog(message);
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

    public String receiveString(String message){
        return JOptionPane.showInputDialog(message);
    }

    public void showMessage(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }

}