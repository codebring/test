package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	//����Ÿ��, �޼����, �Ű�����
	//selete
	
	public void loginUser(String user_id);
	public void UserDTOlogin(String user_id);
	  
	
	 public ArrayList<UserDTO> getUser();
	 public void insertUser(UserDTO userDTO);
	 public void updateUser(@Param("user_id") String user_id, @Param("grade") String grade);
	 public void deleteUser(String user_id);
	 

	
	
}
