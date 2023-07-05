package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaStore extends JPanel {
    private final Media media;
    private final JFrame frame;

    public MediaStore(Media media, JFrame frame) {
        this.media = media;
        this.frame = frame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if(media instanceof Playable) { // check Playable interface
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ButtonListener());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if(s.equals("Play")) {
                JDialog d = new JDialog(frame, "Play media");
                JLabel l1 = new JLabel("Playing " + media.getTitle() +
                        " - Length: " + ((Disc) media).getLength(), SwingConstants.CENTER);
                d.add(l1);

                d.setLocationRelativeTo(null); // TODO how to center at the parent frame?
                d.setSize(600, 200);
                d.setVisible(true);

            }
        }
    }
}
