package com.kh.model.vo;

public class Car {

	//필드부
	private int parkingNum;
	private int carNum;
	private int carType;
	private String owner;
	
	//생성자부
	public Car() {
		super();
	}
	public Car(int parkingNum, int carNum, int carType, String owner) {
		super();
		this.parkingNum = parkingNum;
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}
	//메소드부
	public int getParkingNum() {
		return parkingNum;
	}
	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		
		//단, toString() 메소드 오버라이딩 시 각 자동차 타입에 맞게 문자열을 반환할 수 있게 끔
		
		String cType=""; //각 자동차 타임에 맞는 문자열을 임시로 받는 역할
		
		if(carType == 1) {
			cType ="경차";
		}
		else if(carType==2) {
			cType ="세단";
		}
		else if(carType==3) {
			cType ="SUV";
		}
		else if(carType==4) {
			cType ="트럭";
		}
		
		return "Car [parkingNum=" + parkingNum + ", carNum=" + carNum + ", carType=" + cType + ", owner=" + owner
				+ "]";
	}
	
	
	
}
