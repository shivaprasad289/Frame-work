package com.StrongerMe.tableInfoData;

public class CoachInfoTableRecord {
	String coachName;
	long coachNumber;
	String coachEmail;
	String badge;
	String details;
	String certification;

	public CoachInfoTableRecord(String coachName, long coachNumber, String coachEmail, String badge, String details,
			String certification) {
		super();
		this.coachName = coachName;
		this.coachNumber = coachNumber;
		this.coachEmail = coachEmail;
		this.badge = badge;
		this.details = details;
		this.certification = certification; 
	}
	public CoachInfoTableRecord(String coachName) {
		super();
		this.coachName = coachName;
	}
	@Override
	public String toString() {
		return "CoachInfoTableRecord [coachName=" + coachName + ", coachNumber=" + coachNumber + ", coachEmail="
				+ coachEmail + ", badge=" + badge + ", details=" + details + ", certification=" + certification + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((badge == null) ? 0 : badge.hashCode());
		result = prime * result + ((certification == null) ? 0 : certification.hashCode());
		result = prime * result + ((coachEmail == null) ? 0 : coachEmail.hashCode());
		result = prime * result + ((coachName == null) ? 0 : coachName.hashCode());
		result = prime * result + (int) (coachNumber ^ (coachNumber >>> 32));
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoachInfoTableRecord other = (CoachInfoTableRecord) obj;
		if (badge == null) {
			if (other.badge != null)
				return false;
		} else if (!badge.equals(other.badge))
			return false;
		if (certification == null) {
			if (other.certification != null)
				return false;
		} else if (!certification.equals(other.certification))
			return false;
		if (coachEmail == null) {
			if (other.coachEmail != null)
				return false;
		} else if (!coachEmail.equals(other.coachEmail))
			return false;
		if (coachName == null) {
			if (other.coachName != null)
				return false;
		} else if (!coachName.equals(other.coachName))
			return false;
		if (coachNumber != other.coachNumber)
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		return true;
	}
	public String getCoachName() {
		return coachName;
	}
	public long getCoachNumber() {
		return coachNumber;
	}
	public String getCoachEmail() {
		return coachEmail;
	}
	public String getBadge() {
		return badge;
	}
	public String getDetails() {
		return details;
	}
	public String getCertification() {
		return certification;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public void setCoachNumber(long coachNumber) {
		this.coachNumber = coachNumber;
	}
	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	

}