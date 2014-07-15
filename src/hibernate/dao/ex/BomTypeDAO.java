package hibernate.dao.ex;

import java.util.List;

public class BomTypeDAO extends hibernate.dao.BomTypeDAO
{

	public List<?> findAll()
	{
		String hql = "from BomType order by id";
		return getHibernateTemplate().find(hql);
	}

}
