package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private final Store store;
    private int[] frameSize = {1024, 768};

    public int[] getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(int[] frameSize) {
        this.frameSize = frameSize;
    }

    public static void main(String[] args) {
        Store store = new Store();
        // populate store
        DigitalVideoDisc d1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc d2 = new DigitalVideoDisc("Before sunrise", "Romance", "Richard Linklater", 70, 20f);

        DigitalVideoDisc d3 = new DigitalVideoDisc("Before sunset", "Romance", "Richard Linklater", 65, 21.5f);

        DigitalVideoDisc d4 = new DigitalVideoDisc("Before midnight", "Romance", "Richard Linklater", 75, 22.3f);

        DigitalVideoDisc d5 = new DigitalVideoDisc("Sadness", "Tragedy", "My Life", 100, 1f);

        DigitalVideoDisc d6 = new DigitalVideoDisc("Eternal Sunshine of the Spotless Mind", "Romance", "Michel Gondry", 150, 21.5f);

        CompactDisc cd1 = new CompactDisc("Chai Mai", "Punk", 50.0f, "7UPPERCUTS");
        CompactDisc cd2 = new CompactDisc("ng'bthg", "Pop/Rock", 30.0f, "Ngot");

        Track track1 = new Track("Wave Alpha", 180);
        cd1.addTrack(track1);
        Track track2 = new Track("Em Dao Nay", 200);
        cd2.addTrack(track2);

        Book book1 = new Book("The Great Gatsby", "Novel", 20.0f);
        book1.addAuthor("F. Scott Fitzgerald");
        book1.setContent("In my younger and more vulnerable years my father gave me some advice that I’ve been turning over in my mind ever since.\n" +
                "“Whenever you feel like criticizing any one,” he told me, “just remember that all the people in this world haven’t had the ad- vantages that you’ve had.”\n" +
                "He didn’t say any more, but we’ve always been unusually communicative in a reserved way, and I understood that he meant a great deal more than that. In consequence, I’m in- clined to reserve all judgments, a habit that has opened up many curious natures to me and also made me the victim of not a few veteran bores. The abnormal mind is quick to detect and attach itself to this quality when it appears in a normal person, and so it came about that in college I was unjustly accused of being a politician, because I was privy to the secret griefs of wild, unknown men. Most of the confidences were unsought — frequently I have feigned sleep, preoccupation, or a hostile lev- ity when I realized by some unmistakable sign that an intimate revelation was quivering on the horizon; for the intimate revel- ations of young men, or at least the terms in which they ex- press them, are usually plagiaristic and marred by obvious sup- pressions. Reserving judgments is a matter of infinite hope. I am still a little afraid of missing something if I forget that, as my father snobbishly suggested, and I snobbishly repeat, a sense of the fundamental decencies is parcelled out unequally at birth.");

        store.addMedia(d1);
        store.addMedia(d2);
        store.addMedia(d3);
        store.addMedia(d4);
        store.addMedia(d5);
        store.addMedia(d6);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(book1);

        new StoreManagerScreen(store);

    }

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(this.frameSize[0], this.frameSize[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        menu.add(viewStore);
        viewStore.addActionListener(new ViewStoreListener());

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new SwitchToAddBookListener());


        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new SwitchToAddCDListener());

        JMenuItem addDVD= new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new SwitchToAddDVDListener());

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = this.store.getItemsInStore();
        for(int i = 0; i < this.store.getItemsInStore().size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), this);
            center.add(cell);
        }
        return center;
    }

    protected class SwitchToAddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddBookToStoreScreen(store);
        }
    }

    protected class SwitchToAddCDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        }
    }

    protected class SwitchToAddDVDListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
    }

    protected class ViewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new StoreManagerScreen(store);
        }
    }
}
