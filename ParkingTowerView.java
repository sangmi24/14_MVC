package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ParkingTowerController;
import com.kh.model.vo.Car;

//view �ð����� �κ�
public class ParkingTowerView {

	//�ʵ��
	private Scanner sc =new Scanner(System.in);
	private ParkingTowerController ptc = new ParkingTowerController();
	
	public void mainMenu() {
		
	  while(true) {
		 
		//����ڿ��� �޴� ������ + �Է� ����  +�Է¹���
		System.out.println("=== ���� Ÿ�� ���� ���α׷� ===");  
		System.out.println("1. ���� ����");
		System.out.println("2. ���� ����");
		System.out.println("3. ������ ���� �˻�");
		System.out.println("4. ��ü ���");
		System.out.println("0. ���α׷� �����ϱ�");
		System.out.println("----------------------------");
		System.out.print("�޴� ����: ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		// ����ڰ� �Է��� �޴� ��ȣ�� ���� � ȭ���� �����ٰ��� ����
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
			System.out.println("���α׷��� �����մϴ�. �ȳ��� ������.");
			return;
		default :
			System.out.println("�߸��� �޴��Դϴ�. �ٽ� �Է��ϼ���.");
		}		
	  }	
	}
	// 1. ���� ������ ȭ��
	public void insertCar() {
		System.out.println("--���� ����---");
		//���� : ���� ��ȣ,���� ����, ���� �̸�(�������� �ڵ��� ����)
		System.out.print("���� ��ȣ : ");
		int carNum =sc.nextInt();
		sc.nextLine();
		
		System.out.print("���� ���� (1.����/ 2.����/3.suv/4.Ʈ��) :  ");
		int carType = sc.nextInt();
		sc.nextLine();
		
		System.out.print("���� : ");
		String owner = sc.nextLine();
		
		//��û=> Controller �޼ҵ� ȣ��
		ptc.insertCar(carNum,carType,owner);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}
	// 2. ���� ������ ȭ��
	public void deleteCar() {
		
		System.out.println("----���� ����----");
		
		// ����: �ڵ��� ��ȣ
		System.out.print("���� ��ȣ: ");
		int carNum = sc.nextInt();
		sc.nextLine();
		
		int result = ptc.deleteCar(carNum); 
		
		if( result>0 ) { //������ ����
			System.out.println("������ �����Ͽ����ϴ�.");
		}
		else { //���� �������� �������� ����(��, ��ã��)
			System.out.println("���� �������� �������� �ʾҽ��ϴ�. ");
		}
	}
	// 3.������ ���� �˻��� ȭ��
	public void searchCar() {	
		System.out.println("--- ������ ���� �˻�---");
		
		//���� �˻�
		System.out.print("���� ���� ���� �˻� : ");
		String owner=sc.nextLine();
		
		//��û => Controller
		ArrayList<Car> searched = ptc.searchCar(owner);
		System.out.println("�˻� ���");
		if(searched.isEmpty()) { //�˻� ����� ���ٸ�
			System.out.println("�˻� ����� �����ϴ�.");
		}
		else { //�˻� ����� �ִٸ� => �� ����(vo)���� �������� ��
			for(Car c : searched) {
				System.out.println( c );
			}			
		}
	}
	// 4.��ü ��¿� ȭ��
	public void selectList() {
		
		System.out.println("--- ��ü ��� ---");
		
		// ��û=> Controller-ArrayList<Car> �޼ҵ忡�� carList ��ü �����ޱ�
		ArrayList<Car> carlist=ptc.selectList();
		
		//�ݺ� �������鼭 ��� : get(i)	
		for(int i=0; i<carlist.size();i++) {
			System.out.println(carlist.get(i));
		}
	}
	
	
	
}







