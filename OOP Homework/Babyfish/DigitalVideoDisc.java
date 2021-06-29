package Babyfish;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class DigitalVideoDisc {
	private String titleString;
	private String categoryString;
	private String directorString;
	private int length;
	private float cost;
	
	public DigitalVideoDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.titleString = title;
	}
	
	public DigitalVideoDisc(String titleString, String categoryString, String directorString, int length, float cost) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.directorString = directorString;
		this.length = length;
		this.cost = cost;
	}

	public DigitalVideoDisc(String titleString, String categoryString, String directorString) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.directorString = directorString;
	}

	public DigitalVideoDisc(String titleString, String categoryString) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
	}

	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public String getCategoryString() {
		return categoryString;
	}
	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}
	public String getDirectorString() {
		return directorString;
	}
	public void setDirectorString(String directorString) {
		this.directorString = directorString;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean search(String s) {
		List<String> list_search = new ArrayList<String>();
		List<String> list_title = new ArrayList<>();
		list_search = toList(s);
		list_title = toList(titleString);
		for (String i:list_search) {
			int check = 1;
			for (String j:list_title) {
				if (i.equals(j))
					check = 0;
			}
			if (check == 1)
				return false;
		}
		return true;
	}
	
	ArrayList<String> toList(String s){
		int l = s.length();
		ArrayList<String> list = new ArrayList<String>();
		String find = "";
		for (int i = 0; i < l; ++i) {
			if (s.charAt(i) == ' ') {
				if (find.equals(""));
				else {
					list.add(find);
					find ="";
				}
			}
			else {
				find += s.charAt(i);
			}
		}
		if (s.charAt(l - 1) != ' ') {
			list.add(find);
		}
		return list;
	}
}




























