package hibernate.dao.ex;

import java.util.List;
import juinfo.hibernate.HibernateDAO;
import org.hibernate.SessionFactory;

public class BomRelationDAO extends hibernate.dao.BomRelationDAO
{

	private HibernateDAO hibernateDAO;

	public BomRelationDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
		hibernateDAO = new HibernateDAO(sessionFactory);
	}

	/*
	 *  
	 */
	public boolean hasCode(String code, String item)
	{
		String hql = String.format("from BomRelation where code = '%s' and item = '%s'", code, item);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public boolean hasCode(String code, String item, Integer id)
	{
		String hql = String.format("from BomRelation where code = '%s' and item = '%s' and id <> %d", code, item, id);
		return getHibernateTemplate().find(hql).size() > 0;
	}
	
	public List<?> findByParentId(Integer parentId)
	{
		String hql = String.format("from BomRelation where parentId = %d", parentId);
		return getHibernateTemplate().find(hql);
	}

	public List<?> searchByParentId(Integer parentId, String searchContext)
	{
		String hql = String.format("from BomRelation where parentId = %d and item.code like '%%%s%%'", parentId,
				searchContext);
		return getHibernateTemplate().find(hql);
	}
	
	public void delete(String code)
	{
		String hql = String.format("delete from BomRelation where code = '%s'", code);
		hibernateDAO.execute(hql);
	}


}
