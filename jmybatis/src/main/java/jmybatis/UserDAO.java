package jmybatis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jmybatis.UserDTO;

public class UserDAO {
	private static final String user_id = null;
	private static final String name = null;
	private static final String id = null;
	//�����Ͱ� �ִ� ����ҷ� �����ϴ� ������ ��ü
	//���� DB�� �����ؼ� �����͸� ����, ����, ��ȸ ��� ����
	//�� �� �ִ� ����� �����Ѵ�. (CRUD�� ������)
	//�����͸� ���� DB�� ������ (MVC ���Ͽ��� Model ����)
	Connection conn = null;
	//�������� �ؼ����ִ� ����
	PreparedStatement pt = null;
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8 & serverTimezone=UTC";
	String dbId = "root";
	String dbPw = "1234";
	private List<UserDTO> user;
	private ResultSet s;
	
	//insert�� �����ϱ�
	//user ���̺� �����͸� ����

	public void InsertUser(UserDTO userDTO) {
		try {
			//JDBC ����̹� �ε�
			Class.forName(dbDriver);
			
			//DB ����
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			//SQL��, ?�� ���� ������ ������ ������
			String InsertSQL = "insert into user values(?, ?, ?, ?, ?, ?)";
			
			//conn SQL�� ���� DB�� �����Ѵٴ� ��
			pt = conn.prepareStatement(InsertSQL);
			
			//SQL �Է� �� ����
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
			
		}//ĳġ ��
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
			}//ĳġ��	
		}
			//Update�� delete ����
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