package jmybatis;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	SqlSessionFactory sqlSessionFactory;
	public void init() {
		try {
			String resource = "jboard/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch(Exception e) {
		System.out.println("MyBatis 설정 파일 가져오기 실패 ㅜㅜ");
		
		e.printStackTrace();
						
		}
		
	}
	
	public ArrayList<BoardDTO> getBoard() {
		//SQL문 처리
		SqlSession session = sqlSessionFactory.openSession();
	    BoardMapper mapper = session.getMapper(BoardMapper.class);
	    ArrayList<BoardDTO> userlist = mapper.getBoard();
	    
	    return userlist;
	    
			}
	public void insertBoard(String id, String writter, String title, String content) {
		SqlSession session = sqlSessionFactory.openSession();
	    BoardMapper mapper = session.getMapper(BoardMapper.class);
	    BoardDTO boardDTO = new BoardDTO(1, id, writter, title, content);
	    mapper.insertBoard(boardDTO);
	    session.commit();
	}
	
	public void updateBoard(String id, String title) {
		SqlSession session = sqlSessionFactory.openSession();
	    BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.updateBoard(id, title);
	    session.commit();
	}
	
	public void deleteBoard(String id) {
		SqlSession session = sqlSessionFactory.openSession();
	    BoardMapper mapper = session.getMapper(BoardMapper.class);
	    mapper.deleteBoard(id);
	    session.commit();
	}

	
	
	}
