package com.elearning.enums;

public enum Status {
	Celibatire,Marie,Veuf;
	 
	 
	 public  static Status fromValue(String value) {
		 if(value.equals("C�libataire")){
			 return Celibatire;
		 }
		 else if (value.equals("Mari�")){
			 return Marie;
		 }
		 else{
			 return Veuf;
		 }
    }
}
