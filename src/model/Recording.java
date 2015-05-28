package model;

import java.util.Date;

public class Recording {
	public final Date timestamp;
	public final double offset;
	public final int lastUpdate;
	public final double jitter;
	public final int reach;
	public final boolean netFail;
	public final boolean hipatFail;
	public final boolean cesiumFail;
	
	public Recording() {
		this.timestamp = new Date();
		this.offset = 12.2;
		this.lastUpdate = 23;
		this.jitter = 0.23;
		this.reach = 45;
		this.netFail = false;
		this.hipatFail = false;
		this.cesiumFail = false;
	}
	
	public Recording(Date timestamp, double offset, int lastUpdate,
			double jitter, int reach, boolean netFail, boolean hipatFail,
			boolean cesiumFail) {
		
		this.timestamp = timestamp;
		this.offset = offset;
		this.lastUpdate = lastUpdate;
		this.jitter = jitter;
		this.reach = reach;
		this.netFail = netFail;
		this.hipatFail = hipatFail;
		this.cesiumFail = cesiumFail;
	}

	@Override
	public String toString() {
		return "Recording [timestamp=" + timestamp + ", offset=" + offset
				+ ", lastUpdate=" + lastUpdate + ", jitter=" + jitter
				+ ", reach=" + reach + ", netFail=" + netFail + ", hipatFail="
				+ hipatFail + ", cesiumFail=" + cesiumFail + "]";
	}
	
	public static void main(String[] args) {
		Recording x = new Recording();
		System.out.println(x);
	}


	
	
	

}
