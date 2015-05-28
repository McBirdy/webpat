package data;
import java.util.ArrayList;

import model.Recording;
import model.Site;

public class Create {
	
	
	public static void main(String[] args) {
		ArrayList<Site> list = new ArrayList<Site>();
		
		list.add(new Site());
		list.add(new Site("Magero", "158.112.111.11", "Testing Magero"));
		list.add(new Site("Soreisa", "12.2.2.3", "Testing Soreisa"));
		list.get(0).recordings.add(new Recording()); 
		System.out.println(list.get(0).recordings.get(0));
		
		
		for (Site site : list) {
			System.out.printf("site: %s comment: %s\n", site.location, site.comment);
		}
	}
}
