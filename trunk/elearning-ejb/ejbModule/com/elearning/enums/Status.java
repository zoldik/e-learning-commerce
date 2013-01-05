package com.elearning.enums;

public enum Status {
	Celibatire,Marie,Veuf;
	 
	 
	 public  static Status fromValue(String value) {
		 if(value.equals("Célibataire")){
			 return Celibatire;
		 }
		 else if (value.equals("Marié")){
			 return Marie;
		 }
		 else{
			 return Veuf;
		 }
    }
}
