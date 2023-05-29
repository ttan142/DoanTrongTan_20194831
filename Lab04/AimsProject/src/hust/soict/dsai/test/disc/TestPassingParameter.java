package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("swap method");
        DVDWrapper jungleDVDWrapper = new DVDWrapper(jungleDVD);
        DVDWrapper cinderellaDVDWrapper = new DVDWrapper(cinderellaDVD);
        swap(jungleDVDWrapper, cinderellaDVDWrapper);
        System.out.println("Jungle DVD title: " + jungleDVDWrapper.dvd.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVDWrapper.dvd.getTitle());

        System.out.println();
        System.out.println("changeTitle method");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD tile: " + cinderellaDVD.getTitle());
    }

    // swap-method version that does not work
    /*
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
     */

    // this works
    public static void swap(DVDWrapper DW1, DVDWrapper DW2) {
        DigitalVideoDisc tmp = DW1.dvd;
        DW1.dvd = DW2.dvd;
        DW2.dvd = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);

    }

}

class DVDWrapper {
    DigitalVideoDisc dvd;
    // constructor
    DVDWrapper(DigitalVideoDisc dvd) {this.dvd = dvd;}
}
