package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();		
		my.init();
		
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("[수행 기능 선택]\n ** 1. 생성 2. 수정 3. 삭제 4. 조회 **\n>> ");
		
		while(true) {
			
			int num = s.nextInt();
			s.nextLine();			
			if(num == 1) {
				
				System.out.println("[값을 입력합니다.]");
				System.out.print("아이디 입력 : ");
				String id = s.next();
				System.out.print("작성자 입력 : ");
				String writter = s.next();
				System.out.print("제목 입력 : ");
				String title = s.next();
				System.out.print("내용 입력 : ");
				String content = s.next();
				
				my.insertBoard(id, writter, title, content);
				
				System.out.print("[수행 기능 선택]\n ** 1. 생성 2. 수정 3. 삭제 4. 조회 **\n>> ");			
			}else if(num == 2) {
				System.out.println("[값을 수정합니다.");
				
				System.out.print("바꿀 아이디 입력 : ");
				String id = s.next();
				System.out.print("수정 할 제목 입력 : ");
				String title = s.next();
				
				my.updateBoard(id, title);
				
				System.out.print("[수행 기능 선택]\n ** 1. 생성 2. 수정 3. 삭제 4. 조회 **\n>> ");				
			}else if(num == 3) {
				System.out.println("[값을 삭제합니다.]");
				System.out.print("삭제 할 아이디 입력 : ");
				String id = s.next();

				my.deleteBoard(id);
				
				System.out.print("[수행 기능 선택]\n ** 1. 생성 2. 수정 3. 삭제 4. 조회 **\n>> ");		
			}else if(num == 4) {
				System.out.println("[값을 조회합니다.]");
				
				ArrayList<BoardDTO> list = my.getBoard();				
				System.out.println(list);
				
				System.out.print("[수행 기능 선택]\n ** 1. 생성 2. 수정 3. 삭제 4. 조회 **\n>> ");
			}else {
				System.out.println("[잘못된 번호]");
				break;
			}
			
		}
			
		}
	
}
