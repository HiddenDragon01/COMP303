package COMP310;

public class Required_Information {
	
	private String aTitle;
	private String aLanguage;
	private String aStudio;
	
	public Required_Information(String pTitle, String pLanguage, String pStudio) {
		this.aTitle = pTitle;
		this.aLanguage = pLanguage;
		this.aStudio = pStudio;
	}
	
	public String getTitle() {
		return this.aTitle;
	}
	
	public String getLanguage() {
		return this.aLanguage;
	}
	
	public String getStudio() {
		return this.aStudio;
	}
	
}
