package hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * BomRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.dao.BomRelation
 * @author MyEclipse Persistence Tools
 */

public class BomRelationDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(BomRelationDAO.class);
	// property constants
	public static final String PARENT_ID = "parentId";
	public static final String ITEM_ID = "itemId";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(BomRelation transientInstance)
	{
		log.debug("saving BomRelation instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BomRelation persistentInstance)
	{
		log.debug("deleting BomRelation instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public BomRelation findById(java.lang.Integer id)
	{
		log.debug("getting BomRelation instance with id: " + id);
		try
		{
			BomRelation instance = (BomRelation) getHibernateTemplate().get("hibernate.dao.BomRelation", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BomRelation instance)
	{
		log.debug("finding BomRelation instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding BomRelation instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from BomRelation as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParentId(Object parentId)
	{
		return findByProperty(PARENT_ID, parentId);
	}

	public List findByItemId(Object itemId)
	{
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByQuantity(Object quantity)
	{
		return findByProperty(QUANTITY, quantity);
	}

	public List findAll()
	{
		log.debug("finding all BomRelation instances");
		try
		{
			String queryString = "from BomRelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public BomRelation merge(BomRelation detachedInstance)
	{
		log.debug("merging BomRelation instance");
		try
		{
			BomRelation result = (BomRelation) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BomRelation instance)
	{
		log.debug("attaching dirty BomRelation instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BomRelation instance)
	{
		log.debug("attaching clean BomRelation instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BomRelationDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BomRelationDAO) ctx.getBean("BomRelationDAO");
	}
}