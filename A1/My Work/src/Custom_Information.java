package COMP310;

import java.util.HashMap;

public class Custom_Information {
	
	private HashMap<String, String> aHash;	
	
	public Custom_Information (HashMap<String, String> pHash) {
		this.aHash = new HashMap<>(pHash);
	}
	
	public HashMap<String, String> getHash () {
		return new HashMap<>(this.aHash);
	}
	
	public void setCustom (String a, String b) {
		aHash.put(a, b);
	}
	
	public void getCustom (String a) {
		aHash.get(a);
	}
}
