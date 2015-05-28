package controller;

import model.*;
import java.util.ArrayList;

public interface FetchData {
	
	public Recording getLatestRecording(Site originSite);
	
	public ArrayList<Recording> getAllRecordings(Site originSite);
	

}
