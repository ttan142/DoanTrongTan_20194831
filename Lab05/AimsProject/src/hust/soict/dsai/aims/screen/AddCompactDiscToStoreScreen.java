package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfTrackList;
    private JTextField tfLength;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Add CD Screen");
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
        tfArtist = new JTextField(10);
        tfTrackList = new JTextField(10);
        tfLength = new JTextField(10);

        tfPanel.add(new JLabel("Title "));
        tfPanel.add(tfTitle);
        tfPanel.add(new JLabel("Cost "));
        tfPanel.add(tfCost);
        tfPanel.add(new JLabel("Category "));
        tfPanel.add(tfCategory);
        tfPanel.add(new JLabel("Artist "));
        tfPanel.add(tfArtist);
        tfPanel.add(new JLabel("Tracks "));
        tfPanel.add(tfTrackList);
        tfPanel.add(new JLabel("Length "));
        tfPanel.add(tfLength);

        // mainPanel and its components
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font font = new Font("MS Sans Serif", Font.BOLD, 15);
        JLabel tfTitleDisplay = new JLabel("Add a CD to store");

        tfTitleDisplay.setFont(font);
        tfTitleDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton = new JButton("Add CD");
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
            ArrayList<Track> CDTrackList = new ArrayList<>();

            for(int i=0; i < Arrays.asList(tfTrackList.getText().split("\\s*,\\s*")).size(); i++) {
                CDTrackList.add(new Track(Arrays.asList(tfTrackList.getText().split("\\s*,\\s*")).get(i)));
            }

            if(button.equals("Add CD")) {
                JOptionPane.showMessageDialog(null,"CD " + tfTitle.getText() +  "added successfully","Add CD",JOptionPane.INFORMATION_MESSAGE);
                store.addMedia(new CompactDisc(tfTitle.getText(),
                        tfCategory.getText(),
                        Float.parseFloat(tfCost.getText()),
                        Integer.parseInt(tfLength.getText()),
                        tfArtist.getText(), CDTrackList));
                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfTrackList.setText("");
                tfArtist.setText("");
                tfLength.setText("");
            }
        }
    }


}
