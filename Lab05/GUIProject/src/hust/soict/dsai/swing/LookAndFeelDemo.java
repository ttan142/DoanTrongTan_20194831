package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelDemo extends JFrame {
    public LookAndFeelDemo() {
        addDemoComponents();
        addLookAndFeelComboBox();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LookAndFeelDemo();
    }

    void addDemoComponents() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JLabel("Label: "));
        cp.add(new JTextField("Text field"));
        cp.add(new JRadioButton("Radio button"));
        cp.add(new JButton("Button"));
    }

    void addLookAndFeelComboBox() {
        Container cp = getContentPane();
        cp.add(new JLabel("Change Look and Feel here: "));

        // create combo box
        UIManager.LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();

        String[] lafNames = new String[lafInfos.length+2];
        String[] lafClass = new String[lafInfos.length+2];
        for(int i = 0; i < lafInfos.length; i++) {
            lafNames[i] = lafInfos[i].getName();
            lafClass[i] = lafInfos[i].getClassName();
        }

        lafNames[lafInfos.length] = "Java";
        lafClass[lafInfos.length] = UIManager.getCrossPlatformLookAndFeelClassName();

        lafNames[lafInfos.length+1] = "System";
        lafClass[lafInfos.length+1] = UIManager.getSystemLookAndFeelClassName();

        JComboBox cbLookAndFeel = new JComboBox(lafNames);
        cp.add(cbLookAndFeel);

        // handle change look and feel
        JFrame frame = this;
        cbLookAndFeel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = cbLookAndFeel.getSelectedIndex();
                try {
                    UIManager.setLookAndFeel(lafClass[index]);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(frame);
                setTitle(lafNames[index] + " Look And Feel");
            }
        });
    }


}
