package hibernate.dao.ex;

import java.util.List;

import juinfo.paper.PaperHQL;

public class ProviderDAO extends hibernate.dao.ProviderDAO implements PaperHQL
{


	
	public String getHQLFind() {
		return "from Provider order by id";
	}

	public String getHQLFindCount() {
		return "select count(*) from Provider";
	}

	public String getHQLSearch(String key) {
		String hql = String.format("from Provider where name like '%%%s%%'  order by id", key);		
		return hql;
	}

	public String getHQLSearchCount(String key) {
		String hql = String.format(
				"select count(*) from Provider where name like '%%%s%%'", key);
		return hql;
	}

	/**
	 * method
	 * 
	 * **/
	public List<?> likeByName(String name)
	{
		String hql = String.format("from Provider where name like '%%%s%%'", name);
		return getHibernateTemplate().find(hql);
	}


}
