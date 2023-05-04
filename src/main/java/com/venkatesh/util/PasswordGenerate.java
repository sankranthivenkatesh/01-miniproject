package com.venkatesh.util;

import java.util.Random;

public class PasswordGenerate {
	
		public static String temppassword(int len) {
		    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    Random rnd = new Random();

		    StringBuilder sb = new StringBuilder(len);
		    for (int i = 0; i < len; i++) {
		        sb.append(AB.charAt(rnd.nextInt(AB.length())));
		    }
		    return sb.toString();
		
		
		
	
	}
   
}
