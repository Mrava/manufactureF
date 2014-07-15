package hibernate.dao.ex;

import java.util.List;
import juinfo.hibernate.HibernateDAO;

public class MenuDAO extends hibernate.dao.MenuDAO {
	
	
	
	// 查找主标签
	public List<?> getMenuName() {
		String hql = "from Menu where parent_id=0 order by idx";
		return getHibernateTemplate().find(hql);
	}

	// 查找副标签 
	public List<?> getMenuNames() {
		String hql = "from Menu where parent_id > 0 order by parent_id, idx";
		return getHibernateTemplate().find(hql);
	}
	/****
	 * 修改目录
	 * 
	 * *****/
	//新的ID（一级）
	public int getNewId(){
		String hql="select count(*) from Menu where parent_id=0";
		HibernateDAO dao = new HibernateDAO(getSessionFactory());
		Long count=(Long)dao.getValue(hql);
		return count.intValue()+10 ;
	}
	//新的ID（二级）
	public int getSedId(int id){
		String hql="select count(*) from Menu where parent_id="+id;
		HibernateDAO dao = new HibernateDAO(getSessionFactory());
		Long count=(Long)dao.getValue(hql);
		return id*10+count.intValue()+1 ;
	}
	//新的IDX（一级）
	public int getNewIdX(){
		String hql="select count(*) from Menu where parent_id=0";
		HibernateDAO dao = new HibernateDAO(getSessionFactory());
		Long count=(Long)dao.getValue(hql);
		return count.intValue()+1 ;
	}
	//新的IDX（二级）
	public int getSedIdX(int id){
		String hql="select count(*) from Menu where parent_id="+id;
		HibernateDAO dao = new HibernateDAO(getSessionFactory());
		Long count=(Long)dao.getValue(hql);
		return count.intValue()+1 ;
	}
	//一级标签下是否有二级标签

	
}
