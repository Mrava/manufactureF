package hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * BillType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.dao.BillType
 * @author MyEclipse Persistence Tools
 */

public class BillTypeDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(BillTypeDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String STOCK = "stock";
	public static final String REMARK = "remark";

	protected void initDao()
	{
		// do nothing
	}

	public void save(BillType transientInstance)
	{
		log.debug("saving BillType instance");
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

	public void delete(BillType persistentInstance)
	{
		log.debug("deleting BillType instance");
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

	public BillType findById(java.lang.Integer id)
	{
		log.debug("getting BillType instance with id: " + id);
		try
		{
			BillType instance = (BillType) getHibernateTemplate().get("hibernate.dao.BillType", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BillType instance)
	{
		log.debug("finding BillType instance by example");
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
		log.debug("finding BillType instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from BillType as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByStock(Object stock)
	{
		return findByProperty(STOCK, stock);
	}

	public List findByRemark(Object remark)
	{
		return findByProperty(REMARK, remark);
	}

	public List findAll()
	{
		log.debug("finding all BillType instances");
		try
		{
			String queryString = "from BillType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public BillType merge(BillType detachedInstance)
	{
		log.debug("merging BillType instance");
		try
		{
			BillType result = (BillType) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BillType instance)
	{
		log.debug("attaching dirty BillType instance");
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

	public void attachClean(BillType instance)
	{
		log.debug("attaching clean BillType instance");
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

	public static BillTypeDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BillTypeDAO) ctx.getBean("BillTypeDAO");
	}
}