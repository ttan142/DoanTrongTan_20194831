package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfContent;
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add Book Screen");
        int[] frameSize = (new StoreManagerScreen(store)).getFrameSize();
        setSize(frameSize[0], frameSize[1]);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    JPanel createCenter() {
        JPanel tfPanel = new JPanel();
        tfPanel.setLayout(new GridLayout(3, 2, 3, 3));
        tfPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        tfTitle = new JTextField(10);
        tfCost = new JTextField(10);
        tfCategory = new JTextField(10);
        tfContent = new JTextField(30);
        tfAuthors = new JTextField(20);

        tfPanel.add(new JLabel("Title "));
        tfPanel.add(tfTitle);
        tfPanel.add(new JLabel("Cost "));
        tfPanel.add(tfCost);
        tfPanel.add(new JLabel("Category "));
        tfPanel.add(tfCategory);
        tfPanel.add(new JLabel("Authors "));
        tfPanel.add(tfAuthors);
        tfPanel.add(new JLabel("Content "));
        tfPanel.add(tfContent);

        // mainPanel and its components
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font font = new Font("MS Sans Serif", Font.BOLD, 15);
        JLabel tfTitleDisplay = new JLabel("Add a book to store");

        tfTitleDisplay.setFont(font);
        tfTitleDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton = new JButton("Add book");
        addButton.addActionListener(new ButtonListener());
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(tfTitleDisplay);
        mainPanel.add(tfPanel);
        mainPanel.add(addButton);

        return mainPanel;
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            if(button.equals("Add book")) {
                JOptionPane.showMessageDialog(null,"Book " + tfTitle.getText() +  "added successfully","Add Book",JOptionPane.INFORMATION_MESSAGE);

                store.addMedia(new Book(
                        tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()), Arrays.asList(tfAuthors.getText().split("\\s*,\\s*")), tfContent.getText()));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfContent.setText("");
                tfAuthors.setText("");

            }

        }
    }

}
