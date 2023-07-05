package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;  // accumulatd sum, init to 0

    // constructor to setup GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));  // layout of frame

        add(new Label("Enter an integer: "));

        tfInput = new TextField(10);  // user enter value here
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());  // listener

        add(new Label("The accumulated sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);  // read-only
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TFInputListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum +"");
        }
    }
}
