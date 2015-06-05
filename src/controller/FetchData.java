package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Recording;
import model.Site;

public interface FetchData {
	
	public Recording getLatestRecording(Site originSite) throws IOException;
	
	public ArrayList<Recording> getAllRecordings(Site originSite);
	

}
