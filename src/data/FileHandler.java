package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
// ----- ATRIBUTTER-----
	private BufferedReader inReader;
	private NtpqVO ntpqObject;
	public ArrayList<NtpqVO> ntpqList;
	
// -----KONSTRUKT�R-----
	public FileHandler(){
		ntpqList = new ArrayList<NtpqVO>();
	}
	
// -----METODER-----
	public void openFile(String dataFile){
		try{
			
			inReader = new BufferedReader(new FileReader(dataFile));
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void closeFile(){
		try{
			inReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// Open the ntpq_output.txt file and read it, line by line, make ntpq objects and add them to the ntpq arrayList
	public void readFile(){
		
		// String to hold the information on the current line
		String thisLine;
		// Clear the ntpq ArrayList every time we read the file
		ntpqList.clear();
		// Open the ntpq_output file
		//openFile("/export/local/m.nordsletten/ntpq_output.txt");
		openFile("/Users/Nords/Desktop/ntpq_output.txt");
		
		// try/catch around the while loop
		try{
			// Loop while the file still have something to read - loops to the end of the file.
			while ((thisLine = inReader.readLine()) != null){
				// check if thisLine is null = end of file
				if(thisLine.equals(null) || thisLine.equals("")){
					//end of file
				// else make ntpq object from the string
				}else{
					ntpqObject = new NtpqVO();
					// split the string into array of strings on a regex that split on whitespaces. Will remove whitespace.
					String [] tokens = thisLine.split("\\s+");
					int tempInt;
					double tempDouble;
					// use the object's set methods with the strings in the array tokens
					ntpqObject.setRemote(tokens[0]);
					ntpqObject.setRefid(tokens[1]);
					ntpqObject.setSt(tokens[2]);
					ntpqObject.setT(tokens[3]);
					// check if the string can be parsed to a double
					if(isDouble(tokens[4])){
						tempDouble = Double.parseDouble(tokens[4]);
						ntpqObject.setWhen(tempDouble);
					// if not give the value -1 to be replaced with '-' when displayed on the website
					}else{
						ntpqObject.setWhen(-1);
					}
					
					// parse the string to int and double to match the variable. 
					// IMPORTANT: if the value can be something else than what it is suppose to be, int or double, we have to check if it can be parsed before we do so.
					tempInt = Integer.parseInt(tokens[5]);
					ntpqObject.setPoll(tempInt);
					tempInt = Integer.parseInt(tokens[6]);
					ntpqObject.setReach(tempInt);
					tempDouble = Double.parseDouble(tokens[7]);
					ntpqObject.setDelay(tempDouble);
					tempDouble = Double.parseDouble(tokens[8]);
					ntpqObject.setOffset(tempDouble);
					tempDouble = Double.parseDouble(tokens[9]);
					ntpqObject.setJitter(tempDouble);
					
					// use the object's setStatus method to get the status based on its other values
					ntpqObject.setStatus();
					// add the object to the ntpq ArrayList
					ntpqList.add(ntpqObject);
				}
			}
		// Catch intput/output exception
		}catch(IOException e){
			// print out the exception to the console
			System.out.println(e);
		}
		// close the file
		closeFile();
	}
	
	// Open the hosts file, read it line by line, loop through the ntpq ArrayList each line to see if the ip on this line matches any of the ips in the list.
	// If there is a match, give the object a comment and set the object's isFoundInEtcHosts to true so the comment is not overwritten.
	public void checkForComment(){
		String thisLine;
		openFile("/etc/hosts");
		
		// try/catch around the while loop
		try{
			// Loop while the file still have something to read - loops to the end of the file.
			while ((thisLine = inReader.readLine()) != null){
				if(thisLine.equals(null) || thisLine.equals("")){
					//end of file
				// else loop through the ntpq ArrayList to see if there is a match in IP
				}else{
					
					// split the string into array of strings on a regex that split on whitespaces. Will remove whitespace.
					String [] tokens = thisLine.split("\\s+");
					
					// loop though the ntpq ArrayList
					for(int i = 0; i < ntpqList.size(); i++){
						// check if the object is allready found in hosts
						if(!ntpqList.get(i).isFoundInEtcHosts()){
							// check if the objects ip equals the ip on the current line in etc hosts
							if(tokens[0].equals(ntpqList.get(i).getRemote())){
								// IP exist in file. Set isFoundInEtcHosts = true
								ntpqList.get(i).setFoundInEtcHosts(true);
								// give the object a comment
								ntpqList.get(i).setComment(tokens[1]);
							}else{
								// IP does not match. Give the object a comment
								ntpqList.get(i).setComment("This ip does not exist in etc/hosts");
							}
						}
					}
				}
			}
		// Catch intput/output exception
		}catch(IOException e){
			// print out the exception to the console
			System.out.println(e);
		}
		// close the file
		closeFile();
	} 
	
	// check if the string can be parsed to a Double
	public boolean isDouble(String s)  
	{  
		// try to parseDouble. If it works, return true, if not return false
		try  
		{  
			Double.parseDouble(s);  
			return true;  
		}  
		catch(NumberFormatException e)  
		{  
			return false;  
		}  
	}  
}
