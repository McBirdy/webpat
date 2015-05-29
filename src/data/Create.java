package data;
import java.util.ArrayList;

import model.*;

public class Create {
	
	
	public static void main(String[] args) {
		ArrayList<Site> list = new ArrayList<Site>();
		
		list.add(new Site("Test", "176.31.45.66", "comment"));
		list.get(0).update();
		
		
		
		
		
		
		
		for (Site site : list) {
			System.out.printf("site: %s comment: %s\n", site.location, site.comment);
			System.out.println(site.getLastRecording());
			
		}
	}
}
