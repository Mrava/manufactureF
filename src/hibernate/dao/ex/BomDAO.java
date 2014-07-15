package hibernate.dao.ex;

import java.util.List;

import org.hibernate.SessionFactory;

import juinfo.hibernate.HibernateDAO;
import juinfo.paper.PaperHQL;;

public class BomDAO extends hibernate.dao.BomDAO implements PaperHQL
{

	private HibernateDAO hibernateDAO;
	
	public BomDAO(SessionFactory sessionFactory)
	{
		hibernateDAO = new HibernateDAO(sessionFactory);
		super.setSessionFactory(sessionFactory);
	}
	
	public String getHQLFind()
	{
		return "from Bom order by code";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from Bom";
	}

	public String getHQLSearch(String key)
	{
		String hql = String.format(
				"from Bom where numero like '%%%s%%' or code like '%%%s%%' or name like '%%%s%%' order by code", key,
				key, key);
		return hql;
	}

	public String getHQLSearchCount(String key)
	{
		String hql = String.format(
				"select count(*) from Bom where numero like '%%%s%%' or code like '%%%s%%' or name like '%%%s%%'", key,
				key, key);
		return hql;
	}

	/*
	 * Methods
	 */

	public List<?> findAllOrder(String propertyName)
	{
		String hql = String.format("from Bom order by %s", propertyName);
		return getHibernateTemplate().find(hql);
	}

	public List<?> findAllOrder()
	{
		return findAllOrder(CODE);
	}

	public List<?> likeByNumero(String key)
	{
		String hql = String.format("from Bom where numero like '%%%s%%' order by numero", key);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByNumero(String key, int resultRows)
	{
		String hql = String.format("from Bom where numero like '%%%s%%' and rownum <= %d order by numero", key,
				resultRows);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByCode(String key)
	{
		String hql = String.format("from Bom where code like '%%%s%%'", key);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByCode(String key, Integer resultRows)
	{
		String hql = String.format("from Bom where code like '%%%s%%' and rownum <= %d order by code", key, resultRows);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByName(String key)
	{
		String hql = String.format("from Bom where name like '%%%s%%' order by code", key);
		return getHibernateTemplate().find(hql);
	}

	public List<?> likeByName(String key, Integer resultRows)
	{
		String hql = String.format("from Bom where name like '%%%s%%' and rownum <= %d order by name", key, resultRows);
		return getHibernateTemplate().find(hql);
	}

	// 判断code是否唯一
	public boolean hasCode(String code)
	{
		String hql = String.format("from Bom where code = '%s'", code);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public boolean hasCode(String code, Integer id)
	{
		String hql = String.format("from Bom where code = '%s' and id <> %d", code, id);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public boolean hasNumero(String numero)
	{
		String hql = String.format("from Bom where numero = '%s'", numero);
		return getHibernateTemplate().find(hql).size() > 0;
	}

	public boolean hasNumero(String numero, Integer id)
	{
		String hql = String.format("from Bom where numero = '%s' and id <> %d", numero, id);
		return getHibernateTemplate().find(hql).size() > 0;
	}
	
	public void calcMaterial(Integer id)
	{
		String sql = String.format("{call juinfo.sp_bom_material_single(%d)}", id);
		hibernateDAO.executeSQL(sql);
	}

}
