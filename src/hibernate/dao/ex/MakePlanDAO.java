package hibernate.dao.ex;

import java.util.List;
import juinfo.paper.PaperHQL;
import org.hibernate.SessionFactory;

public class MakePlanDAO extends hibernate.dao.MakePlanDAO implements PaperHQL
{

	public MakePlanDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}

	/*
	 * PaperHQL
	 */
	public String getHQLFind()
	{
		return "from MakePlan order by tdate desc, bom.code";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from MakePlan order by tdate desc, bom.code";
	}

	public String getHQLSearch(String key)
	{
		return String.format("from MakePlan where bom.code like '%%%s%%' or bom.numero like '%%%s%%' order bom.code",
				key, key);
	}

	public String getHQLSearchCount(String key)
	{
		return String.format("select count(*) from MakePlan where bom.code like '%%%s%%' or bom.numero like '%%%s%%'",
				key, key);
	}

	/*
	 * Methods
	 */
	public List<?> findAllOrder()
	{
		String hql = String.format("from MakePlan order by tdate desc, bom.code");
		return getHibernateTemplate().find(hql);
	}


}
