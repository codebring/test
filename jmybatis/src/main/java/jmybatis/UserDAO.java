package jmybatis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jmybatis.UserDTO;

public class UserDAO {
	private static final String user_id = null;
	private static final String name = null;
	private static final String id = null;
	//데이터가 있는 저장소로 접근하는 유일한 객체
	//직접 DB에 접근해서 데이터를 삽입, 삭제, 조회 등등 조작
	//할 수 있는 기능을 수행한다. (CRUD를 수행함)
	//데이터를 실제 DB에 저장함 (MVC 패턴에서 Model 역할)
	Connection conn = null;
	//쿼리문을 해석해주는 역할
	PreparedStatement pt = null;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8 & serverTimezone=UTC";
	String dbId = "root";
	String dbPw = "1234";
	private List<UserDTO> user;
	private ResultSet s;
	
	//insert문 구현하기
	//user 테이블에 데이터를 저장

	public void InsertUser(UserDTO userDTO) {
		try {
			//JDBC 드라이버 로드
			Class.forName(dbDriver);
			
			//DB 연결
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			//SQL문, ?가 써진 순서로 변수를 구분함
			String InsertSQL = "insert into user values(?, ?, ?, ?, ?, ?)";
			
			//conn SQL문 전송 DB로 전달한다는 뜻
			pt = conn.prepareStatement(InsertSQL);
			
			//SQL 입력 값 설정
			pt.setString(1, userDTO.getUser_id());
			pt.setString(2, userDTO.getUser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}//캐치 끝
	}
		public void SelectUser() {
			List<UserDTO> users = new ArrayList<UserDTO>();
			
			try {
				
				Class.forName(dbDriver);
				conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
				String SelectSQL = "select * from user";
				pt = conn.prepareStatement(SelectSQL);
				ResultSet rs = pt.executeQuery();
				
				while(rs.next()) {
					UserDTO dto = new UserDTO(rs.getString("User_id"), rs.getString("User_pw"), rs.getString("name"), rs.getString("phone"),
							rs.getString("grade"), rs.getInt("age"));
					
					users.add(dto);
				}
				
				for(UserDTO oneuser : users) {
					System.out.println(oneuser);
				}
				pt.close();
				conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}//캐치끝	
		}
			//Update랑 delete 구현
		public void UpdateUser(String name, String id) {
			List<UserDTO> users = new ArrayList<UserDTO>();
				try {
				  
					Class.forName(dbDriver);
					
					conn = DriverManager.getConnection(dbUrl, dbId, dbPw);					
					String UpdateSQL = "update user set name = ? where user_id = ?";
					
					pt = conn.prepareStatement(UpdateSQL);

					
					pt.setString(1, name);
					pt.setString(2, user_id);
	
					pt.executeUpdate();
					
					pt.close();
					conn.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 public void DeleteUser(int num) {
			 List<UserDTO> users = new ArrayList<UserDTO>();
				try {
				  
					Class.forName(dbDriver);
					conn = DriverManager.getConnection(dbUrl, dbId, dbPw);					
					String DeleteSQL = "delete from user where user_id = ?";
					pt = conn.prepareStatement(DeleteSQL);
					
					pt.setString(1, id);
	
					pt.executeUpdate();
					
					pt.close();
					conn.close();
					
			  } catch (Exception e) {  
				 e.printStackTrace();
			  }
		 }    
		 
}