package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import controller.FetchViaNtpq;

public class Site {
	public final String location;
	public String ipAddress;
	public String comment;
	public Date lastFail;
	public Date lastActive;
	public int status;
	public ArrayList<Recording> recordings = new ArrayList<Recording>();
	
	public Site() {
		this("Test Location", "123.45.23.76", "Comment number 1");
		this.lastFail = new Date();
		this.lastActive = new Date();
		this.status = 1;
		this.recordings.add(new Recording());
	}
	
	public Site(String location, String ipAddress, String comment) {
		this.location = location;
		this.ipAddress = ipAddress;
		this.comment = comment;
	}
	
	public Recording getLastRecording() {
		/* Returns the last recording stored in the recordings Array */
		return recordings.get(recordings.size() - 1);
	}
	
	public void update() {
		FetchViaNtpq fetcher = new FetchViaNtpq(); 
		try {
			Recording recording = fetcher.getLatestRecording(this);
			recordings.add(recording);
		} catch (FileNotFoundException e) {
			System.out.printf("%s\n", e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			System.out.printf("Ip Address: %s not found in ntpq output\n", this.ipAddress);
			recordings.add(null);
		} 
	}
}
