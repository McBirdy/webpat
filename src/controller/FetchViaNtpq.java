package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.Recording;
import model.Site;

public class FetchViaNtpq implements FetchData {
	private BufferedReader inReader;
	@Override
	public Recording getLatestRecording(Site originSite) {
		
		return null;
	}
	
	@Override
	public ArrayList<Recording> getAllRecordings(Site originSite) {
		return null;
	}
	
	public void FileHandler() {
		try {
			inReader = new BufferedReader(new FileReader("project/ntpq_output.txt"));
		} catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public void closeFile() {
		try {
			inReader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Recording readNtpqFile(Site site) throws IOException{
		String currentLine;
		
		try{
			while((currentLine = inReader.readLine()) != null){
				String[] tokens = currentLine.split("\\s+");
				
				String ipAddress = tokens[0];
				int lastUpdate = Integer.parseInt(tokens[4]);
				int reach = convertLastUpdate(tokens[6]);
				double offset = Double.parseDouble(tokens[7]);
				double jitter = Double.parseDouble(tokens[8]);
				
				if(site.ipAddress.equals(ipAddress)){
					return new Recording(
							new Date(),
							offset,
							lastUpdate,
							jitter,
							reach,
							false,
							false,
							false);
				}				
			}
		}catch(IOException e) {
			throw new IOException();
		}
		throw new IOException();
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
	public static int convertLastUpdate(String reach) {
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
	
	public static void main(String[] args) {
		FetchViaNtpq x = new FetchViaNtpq();
		Site site = new Site("Mag", "17.72.148.52", "coment");
		x.FileHandler();
		try{
			Recording recording = x.readNtpqFile(site);
			System.out.println(recording);
		}catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.println(convertLastUpdate("23h"));
		System.out.println(convertLastUpdate("12"));
		System.out.println(convertLastUpdate("-"));
		
	}

}
