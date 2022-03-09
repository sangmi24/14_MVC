package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ParkingTowerController;
import com.kh.model.vo.Car;

//view 시각적인 부분
public class ParkingTowerView {

	//필드부
	private Scanner sc =new Scanner(System.in);
	private ParkingTowerController ptc = new ParkingTowerController();
	
	public void mainMenu() {
		
	  while(true) {
		 
		//사용자에게 메뉴 보여줌 + 입력 유도  +입력받음
		System.out.println("=== 주차 타워 관리 프로그램 ===");  
		System.out.println("1. 차량 주차");
		System.out.println("2. 차량 출차");
		System.out.println("3. 주차된 차량 검색");
		System.out.println("4. 전체 출력");
		System.out.println("0. 프로그램 종료하기");
		System.out.println("----------------------------");
		System.out.print("메뉴 선택: ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		// 사용자가 입력한 메뉴 번호에 따라 어떤 화면을 보여줄건지 결정
		switch(menu){
		case 1:
			insertCar();
			break;
		case 2:
			deleteCar();
			break;
		case 3:
			searchCar();
			break;
		case 4:
			selectList();
			break;
		case 0:
			System.out.println("프로그램을 종료합니다. 안녕히 가세요.");
			return;
		default :
			System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
		}		
	  }	
	}
	// 1. 차량 주차용 화면
	public void insertCar() {
		System.out.println("--차량 주차---");
		//주차 : 차량 번호,차량 종류, 차주 이름(실질적인 자동차 정보)
		System.out.print("차량 번호 : ");
		int carNum =sc.nextInt();
		sc.nextLine();
		
		System.out.print("차량 종류 (1.경차/ 2.세단/3.suv/4.트럭) :  ");
		int carType = sc.nextInt();
		sc.nextLine();
		
		System.out.print("차주 : ");
		String owner = sc.nextLine();
		
		//요청=> Controller 메소드 호출
		ptc.insertCar(carNum,carType,owner);
		System.out.println("주차가 완료되었습니다.");
	}
	// 2. 차량 출차용 화면
	public void deleteCar() {
		
		System.out.println("----차량 출차----");
		
		// 출차: 자동차 번호
		System.out.print("차량 번호: ");
		int carNum = sc.nextInt();
		sc.nextLine();
		
		int result = ptc.deleteCar(carNum); 
		
		if( result>0 ) { //출차에 성공
			System.out.println("출차에 성공하였습니다.");
		}
		else { //현재 이차량은 주차되지 않음(즉, 못찾음)
			System.out.println("현재 이차량은 주차되지 않았습니다. ");
		}
	}
	// 3.주차된 차량 검색용 화면
	public void searchCar() {	
		System.out.println("--- 주차된 차량 검색---");
		
		//차주 검색
		System.out.print("주차 차량 차주 검색 : ");
		String owner=sc.nextLine();
		
		//요청 => Controller
		ArrayList<Car> searched = ptc.searchCar(owner);
		System.out.println("검색 결과");
		if(searched.isEmpty()) { //검색 결과가 없다면
			System.out.println("검색 결과가 없습니다.");
		}
		else { //검색 결과가 있다면 => 차 정보(vo)에서 내보내야 함
			for(Car c : searched) {
				System.out.println( c );
			}			
		}
	}
	// 4.전체 출력용 화면
	public void selectList() {
		
		System.out.println("--- 전체 출력 ---");
		
		// 요청=> Controller-ArrayList<Car> 메소드에서 carList 전체 돌려받기
		ArrayList<Car> carlist=ptc.selectList();
		
		//반복 돌려가면서 출력 : get(i)	
		for(int i=0; i<carlist.size();i++) {
			System.out.println(carlist.get(i));
		}
	}
	
	
	
}







