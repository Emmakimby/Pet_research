package pet_project;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Man_InfoDao Mdao = new Man_InfoDao();
		Pet_InfoDao Pdao = new Pet_InfoDao();
		Pet_TypeDao Tdao = new Pet_TypeDao();

		Man_InfoVo Mvo = new Man_InfoVo();
		Pet_InfoVo Pvo = new Pet_InfoVo();
		Pet_TypeVo Tvo = new Pet_TypeVo();
		
		Mvo.setAge(30);
		Mvo.setHouse(1);
		Mvo.setPet("Y");
	
		System.out.println(Mvo.getAge());
		System.out.println(Mvo.getHouse());
		System.out.println(Mvo.getPet());
		System.out.println(Mdao.searchNumber(Mvo));
	}
}
