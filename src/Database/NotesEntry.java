package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotesEntry {
	/*
	 * use clinicalSystem;
CREATE TABLE `vetNotes` (
  `accessionNumber` varchar(50) NOT NULL,
  `animalName` varchar(50) DEFAULT NULL,
  `Species` varchar(50) DEFAULT NULL,
  `noteDate` date NOT NULL,
  `noteTime` time NOT NULL,
  `vet` varchar(50) DEFAULT NULL,
  `history` text,
  `examination` text,
  `assessment` text,
  `plan` text,
  `entryType` enum('follow_up','initial') DEFAULT NULL,
  `bodyweight` decimal(7,3) DEFAULT NULL,
  `respRate` int(5) DEFAULT NULL,
  `animalstatus` enum('AZWH','Carer','Dead','Released') DEFAULT NULL,
  PRIMARY KEY (`accessionNumber`,`noteDate`,`noteTime`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
	 */
	
	private String accessionNumber;
	private String animalName;
	private String species;
	private String animalStatus;
	private String date;
	private String time;
	private String vet;
	private String history;
	private String examination;
	private String assessment;
	private String plan;
	private String type;
	private double bodyWeight;
	private int resp;
	
	

	public NotesEntry (String accessionNumber, 
			String name,
			String species,
			String date,
			String time,
			String vet,
			String history,
			String examination,
			String assessment,
			String plan,
			String type,
			double bodyWeight,
			int resp,
			String animalStatus){
		this.accessionNumber = accessionNumber;
		this.animalName = name;
		this.species = species;
		this.date = date;
		this.time = time;
		this.vet = vet;
		this.history = history;
		this.examination = examination;
		this.assessment = assessment;
		this.plan = plan;
		this.type = type;
		this.bodyWeight = bodyWeight;
		this.resp = resp;
		this.animalStatus = animalStatus;
	}
	
	public static ArrayList<NotesEntry> buildFromRS(ResultSet rs) {
		ArrayList<NotesEntry> notesEntries = new ArrayList<NotesEntry>();
		try {
		//STEP 5: Extract data from result set
	      while(rs.next()){ 
	         //Retrieve by column name
	    	 String anum = rs.getString("accessionNumber"); 
	    	 String aname = rs.getString("animalName"); 
	    	 String d = rs.getString("noteDate"); 
	    	 String t = rs.getString("noteTime"); 
	    	 String v = rs.getString("vet"); 
	    	 String aspecies = rs.getString("species"); 
	    	 String status = rs.getString("animalStatus"); 
	    	 String h = rs.getString("history"); 
	    	 String ex = rs.getString("examination"); 
	    	 String as = rs.getString("assessment"); 
	    	 String pl = rs.getString("plan"); 
	    	 String notetype = rs.getString("entryType"); 
	    	 double bodyW  = rs.getDouble("bodyWeight");
	         int rr = rs.getInt("respRate");
			
	         notesEntries.add(new NotesEntry(anum, aname, aspecies, d, t, v, h, ex, as, pl, notetype, bodyW, rr, status));
	         
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notesEntries;
		
	}
	public String getSpecies() {
		return species;
	}

	public String getAnimalStatus() {
		return animalStatus;
	}
	
	public String getAccessionNumber() {
		return accessionNumber;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getVet() {
		return vet;
	}

	public String getHistory() {
		return history;
	}

	public String getExamination() {
		return examination;
	}

	public String getAssessment() {
		return assessment;
	}

	public String getPlan() {
		return plan;
	}

	public String getType() {
		return type;
	}

	public double getBodyWeight() {
		return bodyWeight;
	}

	public int getResp() {
		return resp;
	}

}
