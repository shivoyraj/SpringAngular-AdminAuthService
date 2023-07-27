package com.org.utility;

import java.util.Base64;

public class PasswordEncryption {

	public static String encrypt(String s) {

		char[] ch = Base64.getEncoder().encodeToString(s.getBytes()).toCharArray();
		s = "";
		for (int i = 0; i < ch.length; i++) {

			if (i % 2 == 0)
				ch[i] = (char) ((ch[i] + 7) % 143859);
			else
				ch[i] = (char) ((ch[i] + 11) % 143859);
			s = s + ch[i];
		}
		return s;

	}

	public static String decrypt(String s) {

		char[] ch = s.toCharArray();
		s = "";

		for (int i = 0; i < ch.length; i++) {

			if (i % 2 == 0)
				ch[i] = (char) ((ch[i] - 7) % 143859);
			else
				ch[i] = (char) ((ch[i] - 11) % 143859);
			s = s + ch[i];

		}
		return new String(Base64.getDecoder().decode(s));
	}

}
