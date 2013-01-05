package com.elearning.enums;

public enum Sex {
	Homme(0,"homme"), Femme(1,"femme");
	 
	 private int key;
	 private String value;
	 
	 Sex(int key, String value) {
		 this.key = key;
		 this.value = value;
     }
	 
	 public  static Sex fromValue(String value) {
		 if(value.equals("Homme")){
			 return Homme;
		 }
		 else{
			 return Femme;
		 }
    }

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
