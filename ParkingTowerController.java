package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Car;

//controller 기능적인 부분
public class ParkingTowerController{

	//필드부
	private ArrayList<Car> carList = new ArrayList<>();
	
	//메소드부
	//1.차량 주차용 화면
	public void insertCar(int carNum,int carType, String owner) {
		
		// carList 에 추가하기 전에 생각해야 할것!
		// Car 객체를 완성시켜야함! (parkingNum이 채워진 상태로 추가해야함)
		
		// 주차 번호 : 마지막 차의 주차번호 + 1
		// 마지막 차의 주차번호를 알려면 마지막 인덱스를 알아야 함 == size() - 1
		int parkingNum = 0; //일단 초기화 시킨다. 
		
		if(carList.isEmpty()) { // 만약 현재 주차된 차량이 한대도 없다면
			parkingNum = 1;	//주차번호는 1부터 시작		
		}else {  //현재 주차타워 리스트에 마지막 인덱스 자리에 주차된 차의 주차번호 + 1
		
			// carList.get( carList.size() -1 )=> 현재 리스트에 마지막 인덱스 자리
			parkingNum=carList.get(carList.size()-1).getParkingNum()+1;		
		}
		Car car = new Car(parkingNum,carNum,carType,owner);
		carList.add(car);
		
	}
	//2.차량 출차용 화면
	public int deleteCar(int carNum) {
		
		//삭제 처리 		
		//1.결과물을 담을 변수 셋팅
		int result= 0;
				
		//2.반복문 이용해서 탐색=> 삭제되면 결과 ++
		//차량을 한대한대 비교함 
		for(int i=0; i<carList.size(); i++) {
			
			//carNum이 일치한다면 삭제
			if(carList.get(i).getCarNum() == carNum ) {
				
				carList.remove(i);
				result++;
			}
		}
		//3.결과값 리턴
		return result;     //result : 삭제된 횟수(건수)
		//0이면 삭제 안됨
		
	}
	//3.주차된 차량 검색용 화면
	public ArrayList<Car> searchCar(String owner){
		
		//1. 결과값을 내보낼 변수 셋팅 : ArrayList<Car> searched
		ArrayList<Car> searched=new ArrayList<>(); //현재 빈 상태
		
		//2. 반복 돌려가면서 검색 처리 : equals(), contains() 자유
		// => 차가 여러대 검색될 가능성이 높으므로 searched에 추가 
		for(int i=0; i<carList.size(); i++) {
		     //차주를 검색을 해야 한다. (차주와 검색차주와 비교)
			if(carList.get(i).getOwner().equals(owner)){
	            searched.add(carList.get(i));
			}
		}
		//3. 결과 리턴
		//return 검색된 결과들이 담긴 list;
		return searched;
	}
	// 4.전체 출력용 화면
	public ArrayList<Car> selectList(){
		//필드 통째로 돌려주기 : carList
		return carList;
	}
	
}






