package com.traffic.test;

public class TestContain {

	public static void main(String[] args) {
		String contain = "/dev/sda3        48G   19G   28G  99% /";
		if(contain.split("9[5-9]%").length>1){
			System.out.println("a");
		}
		
	}

}
