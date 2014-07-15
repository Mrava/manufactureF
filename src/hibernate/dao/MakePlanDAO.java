package hibernate.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * MakePlan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.dao.MakePlan
 * @author MyEclipse Persistence Tools
 */

public class MakePlanDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(MakePlanDAO.class);
	// property constants
	public static final String INDEX_ID = "indexId";
	public static final String BOM_ID = "bomId";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(MakePlan transientInstance)
	{
		log.debug("saving MakePlan instance");
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

	public void delete(MakePlan persistentInstance)
	{
		log.debug("deleting MakePlan instance");
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

	public MakePlan findById(java.lang.Integer id)
	{
		log.debug("getting MakePlan instance with id: " + id);
		try
		{
			MakePlan instance = (MakePlan) getHibernateTemplate().get("hibernate.dao.MakePlan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MakePlan instance)
	{
		log.debug("finding MakePlan instance by example");
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
		log.debug("finding MakePlan instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from MakePlan as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIndexId(Object indexId)
	{
		return findByProperty(INDEX_ID, indexId);
	}

	public List findByBomId(Object bomId)
	{
		return findByProperty(BOM_ID, bomId);
	}

	public List findByQuantity(Object quantity)
	{
		return findByProperty(QUANTITY, quantity);
	}

	public List findAll()
	{
		log.debug("finding all MakePlan instances");
		try
		{
			String queryString = "from MakePlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public MakePlan merge(MakePlan detachedInstance)
	{
		log.debug("merging MakePlan instance");
		try
		{
			MakePlan result = (MakePlan) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MakePlan instance)
	{
		log.debug("attaching dirty MakePlan instance");
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

	public void attachClean(MakePlan instance)
	{
		log.debug("attaching clean MakePlan instance");
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

	public static MakePlanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (MakePlanDAO) ctx.getBean("MakePlanDAO");
	}
}