package COMP310;
import java.util.*;

public class Movie {
	
	private final Required_Information aReqInfo;
	private Custom_Information aCustomInfo = 
			new Custom_Information (new HashMap<String, String>());
	private boolean aValidity;
	private Format aFormat; 
	private final String aFilePath;
	
	public enum Format {
		MP4, MOV, WMV, AVI, FLV, MKV
	}
	public Movie (boolean pValidity, Format pFormat, String aFilePath, String pTitle, String pLanguage, String pStudio) {
		this.aValidity = pValidity;
		this.aFormat = pFormat;
		this.aFilePath = aFilePath;
		this.aReqInfo = new Required_Information(pTitle, pLanguage, pStudio);
	}
	
	public Movie (Movie pMovie) {
		this.aReqInfo = new Required_Information (pMovie.getReqTitle(), pMovie.getReqLanguage(), pMovie.getReqStudio());
		this.aCustomInfo = new Custom_Information(pMovie.getHashMap());
		this.aValidity = pMovie.isValid();
		this.aFormat = pMovie.getFormat();
		this.aFilePath = pMovie.getPath();
	}
	
	public String getPath() {
		return this.aFilePath;
	}
	
	public String getReqTitle() {
		return this.aReqInfo.getTitle();
	}
	
	public String getReqLanguage() {
		return this.aReqInfo.getLanguage();
	}
	
	public String getReqStudio() {
		return this.aReqInfo.getStudio();
	}
	
	public void setCustomInfo (String a, String b) {
		this.aCustomInfo.setCustom(a, b);
	}
	
	public void getCustomInfo (String a) {
		this.aCustomInfo.getCustom(a);
	}
	
	public HashMap<String, String> getHashMap () {
		return this.aCustomInfo.getHash();
	}

	public Format getFormat() {
		return this.aFormat;	
	}
	
	public void deleteFile() {	
		this.aValidity = false;	
	}
	
	public void restoreFile() {	
		this.aValidity = true;
	}
	
	public boolean isValid() {
		return this.aValidity;
	}
	
}
