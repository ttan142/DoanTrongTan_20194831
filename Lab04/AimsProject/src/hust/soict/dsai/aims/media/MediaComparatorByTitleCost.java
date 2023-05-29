package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        if(m1.getTitle().compareToIgnoreCase(m2.getTitle()) != 0) {
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        }
        else {
            if(m1.getCost() < m2.getCost()) {
                return 1;
            }
            else if(m1.getCost() > m2.getCost()) {
                return -1;
            }
            else { return 0; }
        }
    }

}
