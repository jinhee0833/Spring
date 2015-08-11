package com.net.bbs.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.net.bbs.dto.BoardDTO;

public class BoardDAO {
	//dao개체를 spring/context-3-dao.xml문서에서 설정
		
  @Autowired
	private SqlSessionTemplate sqlSession;
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void dbupdate(BoardDTO dto){
		System.out.println("dbupdate");
		sqlSession.update("update", dto);
	}
	
	public void dbdelete(int idx){
		System.out.println("dbdelete");
		sqlSession.delete("delete",idx);
		System.out.println("삭제성공");
	}

	public void dbInsert(BoardDTO dto){
		System.out.println("dbInsert");
		System.out.println("넘어온이름="+dto.getName());
		System.out.println("넘어온제목="+dto.getTitle());
		System.out.println("넘어온내용="+dto.getContent());
		System.out.println("넘어온성별="+dto.getGender());
		System.out.println("넘어온취미="+dto.getHobby());
		System.out.println("넘어온파일="+dto.getImg_file_name());
		
		sqlSession.insert("add",dto);
		System.out.println("저장성공");
	}
	
	public List<BoardDTO> dbSelect(){
		System.out.println("dbSelect");
		List<BoardDTO> list = sqlSession.selectList("selectAll");
		return list;
	}
	
	public BoardDTO dbDetail(int idx){
		System.out.println("dbDetail");
		BoardDTO dto = sqlSession.selectOne("detail",idx);
		return dto;
		
	}
}
