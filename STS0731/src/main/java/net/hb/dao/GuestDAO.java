package net.hb.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.web.servlet.ModelAndView;

import net.hb.dto.GuestDTO;
import oracle.net.aso.e;


public class GuestDAO  {
	@Autowired
	private SqlMapClientTemplate getsqlMapclientTemplate;
	
	public void dbInsert(Map map){ //InsertController.java
		System.out.println("\ndbInsert(Map)");
//		System.out.println("사번="+dto.getSabun());
//		System.out.println("이름="+dto.getName());
//		System.out.println("제목="+dto.getTitle());
//		System.out.println("급여="+dto.getPay());
		Iterator it = map.keySet().iterator();
		while(it.hasNext()==true){
			String data = (String)it.next();
			System.out.println(data + " : " + map.get(data));
		}
		try{
		
			this.getsqlMapclientTemplate.insert("add",map);

		}catch(Exception ex){
			System.out.println("저장실패:"+ex);
		}
	}//end
	
	
	public Map  dbSelect(Map map){ //ListController.java
		System.out.println("Select");
		List list =  getsqlMapclientTemplate.queryForList("selectAll");
		map.put("records", list);
		Iterator it = map.keySet().iterator();
		while(it.hasNext()==true){
			String data = (String)it.next();
			System.out.println(data + " : " + map.get(data));
		}
		return map;
	}//end
	
	public int  dbCount( ){ //Non-static�씪諛섎찓�냼�뱶 
		int total=0;
		return total;
	}//end
	
	public int  dbCountSearch(String skey, String sval ){
		int total=0;
		 
		return total;
	}//end
	
	public Map dbDetail(Map map){
		System.out.println("detail");
		Map maplist = (Map)this.getsqlMapclientTemplate.queryForObject("info", map);
		System.out.println(maplist);
		return maplist;
	}
	
}//class END






















