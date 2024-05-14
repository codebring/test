package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static <BoardDTO> void main(String[] args) {

		DBUtil my = new DBUtil();		
		my.init();
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("[���� ��� ����]\n ** 1. ���� 2. ���� 3. ���� 4. ��ȸ **\n>> ");
		
		while(true) {
			
			int num = s.nextInt();
			s.nextLine();			
			if(num == 1) {
				
				System.out.println("[���� �Է��մϴ�.]");
				System.out.print("���̵� �Է� : ");
				String id = s.next();
				System.out.print("�ۼ��� �Է� : ");
				String writter = s.next();
				System.out.print("���� �Է� : ");
				String title = s.next();
				System.out.print("���� �Է� : ");
				String content = s.next();
				
				my.insertBoard(id, writter, title, content);
				
				System.out.print("[���� ��� ����]\n ** 1. ���� 2. ���� 3. ���� 4. ��ȸ **\n>> ");			
			}else if(num == 2) {
				System.out.println("[���� �����մϴ�.");
				
				System.out.print("�ٲ� ���̵� �Է� : ");
				String id = s.next();
				System.out.print("���� �� ���� �Է� : ");
				String title = s.next();
				
				my.updateBoard(id, title);
				
				System.out.print("[���� ��� ����]\n ** 1. ���� 2. ���� 3. ���� 4. ��ȸ **\n>> ");				
			}else if(num == 3) {
				System.out.println("[���� �����մϴ�.]");
				System.out.print("���� �� ���̵� �Է� : ");
				String id = s.next();

				my.deleteBoard(id);
				
				System.out.print("[���� ��� ����]\n ** 1. ���� 2. ���� 3. ���� 4. ��ȸ **\n>> ");		
			}else if(num == 4) {
				System.out.println("[���� ��ȸ�մϴ�.]");
				
				ArrayList<BoardDTO> list = my.getBoard();				
				System.out.println(list);
				
				System.out.print("[���� ��� ����]\n ** 1. ���� 2. ���� 3. ���� 4. ��ȸ **\n>> ");
			}else {
				System.out.println("[�߸��� ��ȣ]");
				break;
			}
			
		}
		
		System.out.println("Hi");
		System.out.println("Hi");
			
		}
	
}
