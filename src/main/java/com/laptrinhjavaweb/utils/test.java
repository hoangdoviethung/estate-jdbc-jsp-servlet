package com.laptrinhjavaweb.utils;

public class test {
	public static void main(String[] args) {
		int a = 12345;
		int b= 0;
		while(a%10 > 0) {
			b = b*10 +a/10;
		}
		System.out.println(b);
	}
}
