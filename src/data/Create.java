package data;
import java.util.ArrayList;

import controller.SiteBuilder;
import model.*;

public class Create {
	
	
	public static void main(String[] args) {
		ArrayList<Site> siteList = SiteBuilder.getSites();
		//SiteBuilder.updateSites(siteList);
		
		
		
		
		
		
		
		for (Site site : siteList) {
			site.update();
			System.out.printf("site: %s ipAddress: %s comment: %s\n", site.location, site.ipAddress, site.comment);
			System.out.println(site.getLastRecording());
			
		}
	}
}
