package hibernate.dao.ex;

import hibernate.dao.MakeMaterial;

import java.util.List;

import juinfo.hibernate.HibernateDAO;

public class MakeMaterialDAO extends hibernate.dao.MakeMaterialDAO
{
	public HibernateDAO getHibernateDao()
	{
		HibernateDAO dao = new HibernateDAO();
		dao.setSessionFactory(getSessionFactory());
		return dao;
	}

	public void deleteByIndexId(Integer indexId)
	{
		String hql = String.format("delete from MakeMaterial where indexId = %d", indexId);
		getHibernateDao().execute(hql);
	}
	
	public void saveList(List<MakeMaterial> data, Integer indexId)
	{
		this.deleteByIndexId(indexId);
		for(int i =0 ; i< data.size(); i++)
		{
			MakeMaterial material = data.get(i);
			material.setIndexId(indexId);
			save(material);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<MakeMaterial> findByIndexId(Integer indexId)
	{
		String hql = String.format("from MakeMaterial where indexId = %d order by bom.code", indexId);
		return (List<MakeMaterial>) getHibernateTemplate().find(hql);
	}
	
}
