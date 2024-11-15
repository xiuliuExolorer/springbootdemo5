package org.example.springbootdemo5.demos.service.enums;

import java.util.ArrayDeque;
import java.util.HashMap;

class Subtype extends BasicHolder<Subtype>
{
	public Subtype(int No){ this.No = No;

	}
	public Subtype(){
		this.No = 1;
	}

	public static void main(String[] args) {
		Subtype a1 = new Subtype();
		Subtype a2 = new Subtype();
		Subtype a3 = new Subtype(3);
		Subtype a4 = new Subtype(4);
		a2.set(a1);
		a3.set(a2);
		a4.set(a3);
		a4.get().get().get().f();

		Class1 class1 = new Class1();
		class1.test2();
		ArrayDeque<Object> objects = new ArrayDeque<>();
		HashMap<Object, Object> hashMap = new HashMap<>();
//		hashMap.put()


	}
}
