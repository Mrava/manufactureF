package hibernate.dao.ex;

import java.util.List;

import org.hibernate.SessionFactory;

import juinfo.hibernate.HibernateDAO;
import juinfo.hibernate.LoginDAO;

public class UserDAO extends hibernate.dao.UserDAO implements LoginDAO
{
	private HibernateDAO hibernateDAO;
	
	public UserDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
		hibernateDAO = new HibernateDAO(sessionFactory);
	}
	
	
	public List<?> findList()
	{
		String hql = "form User";
		return getHibernateTemplate().find(hql);
	}

	public List<?> findList(int start, int size)
	{
		String hql = "from User";
		return hibernateDAO.findList(hql, start, size);
	}

	public List<?> likeByUserName(String username)
	{
		String hql = String.format("from User where username like '%%%s%%'", username);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByUserName(String username, int start, int size)
	{
		String hql = String.format("from User where username like '%%%s%%'", username);
		return hibernateDAO.findList(hql, start, size);
	}

	public Long getListCount()
	{
		String hql = "select count(*) from User";
		return (Long)hibernateDAO.getValue(hql);
	}
	
	public Long getLikeCount(String username)
	{
		String hql = String.format("select count(*) from User where username like '%%%s%%'", username);
		return (Long)hibernateDAO.getValue(hql);
	}

	public Object login(String username, String password)
	{
		String hql = String.format("from User where username = '%s' and password = '%s'", username, password);
		List<?> list = hibernateDAO.findList(hql);
		if (list.size() == 1)
			return list.get(0);
		else
			return null;
	}
	
}
