package hibernate.dao.ex;

import java.util.List;

public class StudentDAO extends hibernate.dao.StudentDAO
{
	public List<?> likeByName(String key)
	{
		String hql = String.format("from Student where name like '%%%s%%'", key);
		return getHibernateTemplate().find(hql);
	}
	
	
}
