package com.kh.model.vo;

public class Car {

	//�ʵ��
	private int parkingNum;
	private int carNum;
	private int carType;
	private String owner;
	
	//�����ں�
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
	//�޼ҵ��
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
		
		//��, toString() �޼ҵ� �������̵� �� �� �ڵ��� Ÿ�Կ� �°� ���ڿ��� ��ȯ�� �� �ְ� ��
		
		String cType=""; //�� �ڵ��� Ÿ�ӿ� �´� ���ڿ��� �ӽ÷� �޴� ����
		
		if(carType == 1) {
			cType ="����";
		}
		else if(carType==2) {
			cType ="����";
		}
		else if(carType==3) {
			cType ="SUV";
		}
		else if(carType==4) {
			cType ="Ʈ��";
		}
		
		return "Car [parkingNum=" + parkingNum + ", carNum=" + carNum + ", carType=" + cType + ", owner=" + owner
				+ "]";
	}
	
	
	
}
