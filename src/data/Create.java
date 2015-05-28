package data;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import model.Recording;
import model.Site;

public class Create {
	
	
	public static void main(String[] args) {
		
		ArrayList<Site> siteList = new ArrayList<Site>();
		
		siteList.add(new Site());
		siteList.add(new Site("Magero", "158.112.111.11", "Testing Magero"));
		siteList.add(new Site("Soreisa", "12.2.2.3", "Testing Soreisa"));
		siteList.get(1).recordings.add(new Recording()); 
		siteList.get(2).recordings.add(new Recording());
		System.out.println(siteList.get(0).recordings.get(0));
		System.out.println(siteList.get(0).recordings.size());
		//gets the last recording
		//siteList.get(0).recordings.get(siteList.get(0).recordings.size());
		
		
		for (Site site : siteList) {
			System.out.printf("site: %s comment: %s\n", site.location, site.comment);
			System.out.println(site.recordings.get(site.recordings.size() - 1));
		}
	}
}
