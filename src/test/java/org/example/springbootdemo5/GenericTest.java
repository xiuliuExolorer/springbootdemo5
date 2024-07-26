package org.example.springbootdemo5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	@Test
	public  void main2() {
    	List<String> name = new ArrayList<String>();
	    List<Integer> age = new ArrayList<Integer>();
	    List<Number> number = new ArrayList<Number>();
	    name.add("icon");
	    age.add(18);
	    number.add(314);
	    getData(name);
	    getData(age);
	    getData(number);   
	}
	
	// 在此处使用通配符，则可以传入各种类型的 List 泛型，
	public void  getData(List<?> data) {
	    System.out.println("Test date :" + data.get(0));
	}
}
