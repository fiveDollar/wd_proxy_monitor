package com.traffic.test;

public class TestSplit {
	public static void main(String[] args) {
//		/dev/vda1       7.9G  6.5G  1.1G  86% /
		String a = "/dev/vda1       7.9G  6.5G  1.1G  86% /";
//		System.out.println(a.split(" ").length);
		String as[] = a.split(" ");
//		for (String string : as) {
//			System.out.println(string);
//		}
		System.out.println(as[as.length-2]);
	}
}
