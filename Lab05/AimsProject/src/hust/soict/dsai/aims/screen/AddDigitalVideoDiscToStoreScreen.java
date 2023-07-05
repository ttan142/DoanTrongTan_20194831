package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfLength;
    private JTextField tfDirector;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add DVD Screen");
        int[] frameSize = (new StoreManagerScreen(store)).getFrameSize();
        setSize(frameSize[0], frameSize[1]);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(3, 1, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        tfTitle = new JTextField(10);
        tfCost = new JTextField(10);
        tfCategory = new JTextField(10);
        tfDirector = new JTextField(10);
        tfLength = new JTextField(10);

        tfPanel.add(new JLabel("Title "));
        tfPanel.add(tfTitle);
        tfPanel.add(new JLabel("Cost "));
        tfPanel.add(tfCost);
        tfPanel.add(new JLabel("Category "));
        tfPanel.add(tfCategory);
        tfPanel.add(new JLabel("Director "));
        tfPanel.add(tfDirector);
        tfPanel.add(new JLabel("Length "));
        tfPanel.add(tfLength);

        // mainPanel and its components
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font font = new Font("MS Sans Serif", Font.BOLD, 15);
        JLabel tfTitleDisplay = new JLabel("Add a DVD to store");

        tfTitleDisplay.setFont(font);
        tfTitleDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton = new JButton("Add DVD");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonListener btnListener = new ButtonListener();
        addButton.addActionListener(btnListener);

        mainPanel.add(tfTitleDisplay);
        mainPanel.add(tfPanel);
        mainPanel.add(addButton);

        return mainPanel;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            if(button.equals("Add DVD")) {
                JOptionPane.showMessageDialog(null,"DVD " + tfTitle.getText() +  "added successfully","Add DVD",JOptionPane.INFORMATION_MESSAGE);

                store.addMedia(new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText())));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfLength.setText("");
                tfDirector.setText("");
            }
        }
    }

}
