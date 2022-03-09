package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Car;

//controller ������� �κ�
public class ParkingTowerController{

	//�ʵ��
	private ArrayList<Car> carList = new ArrayList<>();
	
	//�޼ҵ��
	//1.���� ������ ȭ��
	public void insertCar(int carNum,int carType, String owner) {
		
		// carList �� �߰��ϱ� ���� �����ؾ� �Ұ�!
		// Car ��ü�� �ϼ����Ѿ���! (parkingNum�� ä���� ���·� �߰��ؾ���)
		
		// ���� ��ȣ : ������ ���� ������ȣ + 1
		// ������ ���� ������ȣ�� �˷��� ������ �ε����� �˾ƾ� �� == size() - 1
		int parkingNum = 0; //�ϴ� �ʱ�ȭ ��Ų��. 
		
		if(carList.isEmpty()) { // ���� ���� ������ ������ �Ѵ뵵 ���ٸ�
			parkingNum = 1;	//������ȣ�� 1���� ����		
		}else {  //���� ����Ÿ�� ����Ʈ�� ������ �ε��� �ڸ��� ������ ���� ������ȣ + 1
		
			// carList.get( carList.size() -1 )=> ���� ����Ʈ�� ������ �ε��� �ڸ�
			parkingNum=carList.get(carList.size()-1).getParkingNum()+1;		
		}
		Car car = new Car(parkingNum,carNum,carType,owner);
		carList.add(car);
		
	}
	//2.���� ������ ȭ��
	public int deleteCar(int carNum) {
		
		//���� ó�� 		
		//1.������� ���� ���� ����
		int result= 0;
				
		//2.�ݺ��� �̿��ؼ� Ž��=> �����Ǹ� ��� ++
		//������ �Ѵ��Ѵ� ���� 
		for(int i=0; i<carList.size(); i++) {
			
			//carNum�� ��ġ�Ѵٸ� ����
			if(carList.get(i).getCarNum() == carNum ) {
				
				carList.remove(i);
				result++;
			}
		}
		//3.����� ����
		return result;     //result : ������ Ƚ��(�Ǽ�)
		//0�̸� ���� �ȵ�
		
	}
	//3.������ ���� �˻��� ȭ��
	public ArrayList<Car> searchCar(String owner){
		
		//1. ������� ������ ���� ���� : ArrayList<Car> searched
		ArrayList<Car> searched=new ArrayList<>(); //���� �� ����
		
		//2. �ݺ� �������鼭 �˻� ó�� : equals(), contains() ����
		// => ���� ������ �˻��� ���ɼ��� �����Ƿ� searched�� �߰� 
		for(int i=0; i<carList.size(); i++) {
		     //���ָ� �˻��� �ؾ� �Ѵ�. (���ֿ� �˻����ֿ� ��)
			if(carList.get(i).getOwner().equals(owner)){
	            searched.add(carList.get(i));
			}
		}
		//3. ��� ����
		//return �˻��� ������� ��� list;
		return searched;
	}
	// 4.��ü ��¿� ȭ��
	public ArrayList<Car> selectList(){
		//�ʵ� ��°�� �����ֱ� : carList
		return carList;
	}
	
}






