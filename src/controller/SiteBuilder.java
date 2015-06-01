package controller;

import java.util.ArrayList;
import java.util.Properties;

import model.Site;
import support.PropertiesLoad;

public class SiteBuilder {
	
	/**
	 * Static method that returns an arraylist of Site objects specified in the properties file.
	 * @return ArrayList<Site> Arraylist of Site objects.
	 */
	public static ArrayList<Site> getSites() {
		// Local variables used
		ArrayList<Site> siteList = new ArrayList<Site>();
		Properties prop = PropertiesLoad.loadProperties(); // Load properties file
		int siteNumber = 1;	// Starting site number to look for
		boolean siteSpecified = true;	// Used to exit while loop

		while (siteSpecified) {
			// Get the values from the properties file
			String siteString = "site" + Integer.toString(siteNumber) + ".";
			String name = prop.getProperty(siteString + "name");
			String ipAddress = prop.getProperty(siteString + "ipAddress");
			String comment = prop.getProperty(siteString + "comment");
			
			// If no values are specified the while loop is exited
			if (name == null && ipAddress == null && comment == null) siteSpecified = false;
			else {
				siteList.add(new Site(name, ipAddress, comment));	// Add new Site
				siteNumber++;	// Look for next site in properties file
			}
		}
		return siteList;
	}
	
	public static void updateSites(ArrayList<Site> siteList) {
		for (Site site : siteList) {
			site.update();
		}
	}
}
