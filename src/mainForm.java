import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainForm  extends JFrame{
    private JPanel mainPanel;
    private JTextArea textConverted;
    private JTextField tfNum;
    private JButton btn_clear;
    private JButton btnConvert;

    public mainForm() {

        setContentPane(mainPanel);
        setTitle("Number to Words Converter v1.0");
        setSize(520, 300);

        setVisible(true);

        // function to be executed if CONVERT button is clicked
        btnConvert.addActionListener(e -> {
            String input_num = tfNum.getText();
            input_num = input_num.replaceAll(" ", ""); // remove whitespace

            Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input_num);
            boolean matchFound = matcher.find();

            if(matchFound) {
                textConverted.setText("invalid input!");
            } else {
                if (input_num.length() > 0){
                    int num = Integer.parseInt(input_num); // cast String to int
                    String convertedNum = NumToWords.convert_num(num);

                    textConverted.setText(convertedNum);
                }
                else {
                    textConverted.setText("please enter a number...");
                }
            }
        });

        // function to be executed if CLEAR button is clicked
        btn_clear.addActionListener(e -> {
            tfNum.setText("");
            textConverted.setText("");
        });
    }

    public static void main(String[] args) {
        mainForm myFrame = new mainForm();
    }

}
