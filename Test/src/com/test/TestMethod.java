package com.test;
import java.util.ArrayList;
import java.util.List;

public class TestMethod {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("567786979999");
		list.add("567786979995");
		list.add("567786979998");
		list.add("567786979997");
		list.add("567786979996");
		
		for(String accountNo : list){
			System.out.println(accountNo);
			
		
		}
      
       
	}
   
}
