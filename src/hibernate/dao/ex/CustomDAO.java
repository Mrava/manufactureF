package hibernate.dao.ex;

import java.util.List;

import juinfo.paper.PaperHQL;

import org.hibernate.SessionFactory;

public class CustomDAO extends hibernate.dao.CustomDAO implements PaperHQL
{

	public CustomDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	public String getHQLFind() {
		return "from Custom order by id";
	}
	
	public String getHQLFindCount() {
		return "select count(*) from Custom";
	}
	
	public String getHQLSearch(String key) {
		String hql = String.format("from Custom where name like '%%%s%%'  order by id", key);		
		return hql;
	}
	
	public String getHQLSearchCount(String key) {
		String hql = String.format(
				"select count(*) from Custom where name like '%%%s%%'", key);
		return hql;
	}
	
	/**
	 * method
	 * 
	 * **/
	
	public List<?> likeByName(String key)
	{
		String hql = String.format("from Custom where name like '%%%s%%'", key);
		return getHibernateTemplate().find(hql);
	}

	public boolean isRightName(String name)
	{
		String hql = String.format("from Custom where name = '%s'", name);
		if (getHibernateTemplate().find(hql).size() > 0)
		{
			return false;
		}
		return true;
	}


}
