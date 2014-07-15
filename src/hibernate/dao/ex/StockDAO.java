package hibernate.dao.ex;

import java.util.List;
import juinfo.paper.PaperHQL;
import org.hibernate.SessionFactory;

public class StockDAO extends hibernate.dao.StockDAO implements PaperHQL
{
	
	public StockDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public String getHQLFind()
	{
		return "from Stock";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from Stock";
	}

	public String getHQLSearch(String key)
	{
		return String.format("from Stock where bom.code like '%%%s%%'", key);
	}

	public String getHQLSearchCount(String key)
	{
		return String.format("select count(*) from Stock where bom.code like '%%%s%%'", key);
	}
	
	public List<?> likeByBomCode(String key)
	{
		String hql = String.format("from Stock where bom.code like '%%%s%%'", key);
		return getHibernateTemplate().find(hql);
	}
	
	public List<?> findAll()
	{
		String hql = "from Stock order by bom.code";
		return getHibernateTemplate().find(hql);
	}
	
	public boolean hasBom(Integer bomId)
	{
		String hql = String.format("from Stock where bomId = %d", bomId);
		return getHibernateTemplate().find(hql).size() > 0 ;
	}
	
	public boolean hasBom(Integer bomId, Integer id)
	{
		String hql = String.format("from Stock where bomId = %d and id <> %d", bomId, id);
		return getHibernateTemplate().find(hql).size() > 0;
	}



}
