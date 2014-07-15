package hibernate.dao.ex;

import java.util.List;

import org.hibernate.SessionFactory;

import juinfo.hibernate.HibernateDAO;

public class BomMaterialDAO extends hibernate.dao.BomMaterialDAO
{
	
	private HibernateDAO hibernateDAO;

	public BomMaterialDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
		hibernateDAO = new HibernateDAO(sessionFactory);
	}
	
	public List<?> likeByItem(String code, String item)
	{
		String hql = String.format("from BomMaterial where code = '%s' and item like '%%%s%%'",  code, item);
		return getHibernateTemplate().find(hql);
	}
	
	public boolean hasCode(String code, String item)
	{
		String hql = String.format("from BomMaterial where code = '%s' and item = '%s'", code, item);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public boolean hasCode(String code, String item, Integer id)
	{
		String hql = String.format("from BomMaterial where code = '%s' and item = '%s' and id <> %d", code, item, id);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public void delete(String code)
	{
		String hql = String.format("delete from BomMaterial where code = '%s'", code);
		hibernateDAO.execute(hql);
	}
	
	public List<?> findByParentId(Integer parentId)
	{
		String hql = String.format("from BomMaterial where parentId = %d", parentId);
		return getHibernateTemplate().find(hql);
	}
	public List<?> searchByParentId(Integer parentId, String searchContext)
	{
		String hql = String.format("from BomMaterial where parentId = %d and item.code like '%%%s%%'", parentId, searchContext);
		return getHibernateTemplate().find(hql);
	}
	
}
