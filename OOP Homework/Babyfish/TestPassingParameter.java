package Babyfish;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD); 
		System.out.println("jungle dvd title: " + jungleDVD.getTitleString());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitleString());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitleString());
		System.out.println("jungle dvd title: " + jungleDVD.getTitleString());
	}
	// Alternative swap
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		String tmp = o1.getTitleString();
		o1.setTitleString(o2.getTitleString());
		o2.setTitleString(tmp);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitleString();
		dvd.setTitleString(title);
		dvd = new DigitalVideoDisc();
	}
}
