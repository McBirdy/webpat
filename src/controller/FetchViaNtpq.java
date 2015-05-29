package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.Recording;
import model.Site;

public class FetchViaNtpq implements FetchData {
	private BufferedReader inReader;
	
	@Override
	public ArrayList<Recording> getAllRecordings(Site originSite) {
		return null;
	}
	
	private void openFile() throws FileNotFoundException{
		String fileLocation = "project/ntpq_output.txt";
		inReader = new BufferedReader(new FileReader(fileLocation));	// Will throw FileNotFoundException
	}
	
	/**
	 * @param site The site from where the recording should come
	 * @throws IOException if no result is found in text file
	 * @return Recording Recording object with data from ntpq output
	 */
	public Recording getLatestRecording(Site site) throws FileNotFoundException, IOException{
		openFile();
		String currentLine;
		
		while((currentLine = inReader.readLine()) != null){
			String[] tokens = currentLine.split("\\s+");
			
			String ipAddress = tokens[0];
			if(site.ipAddress.equals(ipAddress)){	// If the site ipAddress is in the ntpq file
				int lastUpdate = Integer.parseInt(tokens[4]);
				int reach = convertLastUpdate(tokens[6]);
				double offset = Double.parseDouble(tokens[7]);
				double jitter = Double.parseDouble(tokens[8]);
				
				inReader.close();
				
				return new Recording(new Date(), offset, lastUpdate, jitter,
						// Todo: Change the false statements to the actual tests
						reach, false, false, false);
			}
		}
		inReader.close();
		throw new IOException();	// The file did not contain the ip_address of the site
	}
	
	/**Makes sure the reach variable is converted to seconds in a proper way.
	 * Reach can either be:
	 * "-" no packages have ever been received returns -1
	 * "2m" 2 minutes, returns 2 * 60
	 * "23h" 23 hours, returns 23 * 3600
	 * "12d" 12 days, returns 12 * 86400
	 * @param reach The string that is to be converted
	 * @return int Value converted to seconds
	 */
	private static int convertLastUpdate(String reach) {
		try{
			return Integer.parseInt(reach);	// If it is not a valid int an error is called
		}catch(NumberFormatException e) {
			if(reach.equals("-")) return -1;	// No value in field
			
			// Split string into modifier and number
			String secondsModifier = reach.substring(reach.length() -1);
			int number = Integer.parseInt(reach.substring(0, (reach.length() -1)));
			if(secondsModifier.equals("m")) return (number * 60);
			else if(secondsModifier.equals("h")) return (number * 3600);
			else if(secondsModifier.equals("d")) return (number * 86400);
			else return number;	// Last case
		}
		
		
	}
}
