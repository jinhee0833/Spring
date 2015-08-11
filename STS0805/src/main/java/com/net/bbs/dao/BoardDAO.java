package com.net.bbs.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.net.bbs.dto.BoardDTO;

public class BoardDAO {
	//dao��ü�� spring/context-3-dao.xml�������� ����
		
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
		System.out.println("��������");
	}

	public void dbInsert(BoardDTO dto){
		System.out.println("dbInsert");
		System.out.println("�Ѿ���̸�="+dto.getName());
		System.out.println("�Ѿ������="+dto.getTitle());
		System.out.println("�Ѿ�³���="+dto.getContent());
		System.out.println("�Ѿ�¼���="+dto.getGender());
		System.out.println("�Ѿ�����="+dto.getHobby());
		System.out.println("�Ѿ������="+dto.getImg_file_name());
		
		sqlSession.insert("add",dto);
		System.out.println("���强��");
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
