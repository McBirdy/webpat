package data;

public class NtpqVO {
	
// ----- ATRIBUTTER-----
	private int poll, reach;
	private double when, delay, offset, jitter;
	private String remote, refid, st, t, status, comment;
	private boolean isFoundInEtcHosts;
	
// -----KONSTRUKT�R-----
	public NtpqVO(){
		isFoundInEtcHosts = false;
	}
	
	// Constructor with all the values as parameter. (is currently not used)
	public NtpqVO(String remote, String refid, String st, String t, double when, int poll, int reach, double delay, double offset, double jitter, String status, String comment){
		this.remote = remote;
		this.refid = refid;
		this.st = st;
		this.t = t;
		this.when = when;
		this.poll = poll;
		this.reach = reach;
		this.delay = delay;
		this.offset = offset;
		this.jitter = jitter;
		this.status = status;
		this.comment = comment;
		isFoundInEtcHosts = false;
	}
	
// -----METODER-----
	public int getPoll() {
		return poll;
	}

	public void setPoll(int poll) {
		this.poll = poll;
	}

	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}

	public double getDelay() {
		return delay;
	}

	public void setDelay(double delay) {
		this.delay = delay;
	}

	public double getOffset() {
		return offset;
	}

	public void setOffset(double offset) {
		this.offset = offset;
	}

	public double getJitter() {
		return jitter;
	}

	public void setJitter(double jitter) {
		this.jitter = jitter;
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String remote) {
		this.remote = remote;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public double getWhen() {
		return when;
	}

	public void setWhen(double when) {
		this.when = when;
	}

	public String getStatus() {
		return status;
	}
	
	// Set status based on offset value and when value
	public void setStatus() {
		if(offset > 1.5 || offset < -1.5 || when > 60 || jitter > 10000){
			status = "red";
		}else{
			status = "green";
		}
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isFoundInEtcHosts() {
		return isFoundInEtcHosts;
	}

	public void setFoundInEtcHosts(boolean isFoundInEtcHosts) {
		this.isFoundInEtcHosts = isFoundInEtcHosts;
	}
}
