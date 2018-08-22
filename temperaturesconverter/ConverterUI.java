package temperaturesconverter;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.BorderFactory.createLineBorder;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * @author Vik Tolstoi
 */
public class ConverterUI extends javax.swing.JFrame {

    private JLabel label = new JLabel("Enter the temperature");
    private JTextField input = new JTextField();
    private JButton button = new JButton("Convert");
    private JLabel output = new JLabel();
    private GridLayout grid = new GridLayout();

    ConverterUI() {

        JPanel panel = new JPanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Temperatures converter");
        this.setLocation(new java.awt.Point(400, 400));
        this.setSize(300, 100);
        this.setResizable(false);

        panel.setLayout(grid);
        grid.setRows(2);
        grid.setColumns(2);
        output.setBorder(createLineBorder(new java.awt.Color(0, 0, 0)));

        panel.add(label);
        panel.add(input);
        panel.add(button);
        panel.add(output);

        this.add(panel);
    }

    public String getInput() {
        return input.getText();
    }

    public void setOutput(String result) {
        output.setText(result);
    }

    void addButtonListener(ActionListener listenConvertButton) {
        button.addActionListener(listenConvertButton);
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage,
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    boolean isUsersInputValid() {
        boolean checked = false;
        
        try {
            String str = this.getInput();

            if (str.contains(" ") || str.contains("\"")) {
                throw new MyException("Don't use spaces or quotes.");
            }

            int temperature = (Integer.parseInt(str.substring(0, str.length() - 1)));

            String sign = ((str.substring(str.length() - 1)).toUpperCase());

            if (sign.equals("K") || sign.equals("C")
                    || sign.equals("F")) {
            } else {
                throw new MyException("Enter one letter for scale: K or C or F.");
            }

            if ((sign.equals("K") && temperature < 0)
                    || (sign.equals("C") && temperature < -273)
                    || (sign.equals("F") && temperature < -459)) {
                throw new MyException("Absolute zero:\n"
                        + "0 Kelvin, -273 Celsius, -459 Fahrenheit\n"
                        + "Temperatures below absolute zero do not exist.");
            }
            checked = true;

        } catch (MyException e) {
            this.displayErrorMessage(e.getMessage());
        } catch (Exception e) {
            this.displayErrorMessage("Enter temperature as decimal integer number \n"
                    + "and one letter for scale without quotes: \n \"K\" - Kelvin; \n "
                    + "\"C\" - Celsius; \n \"F\" - Farenheit. \n"
                    + "Example: 36C, 99F, 150K.");
        }
        return checked;
    }
}
