package hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * StockFuture entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.dao.StockFuture
 * @author MyEclipse Persistence Tools
 */

public class StockFutureDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(StockFutureDAO.class);

	// property constants

	protected void initDao()
	{
		// do nothing
	}

	public void save(StockFuture transientInstance)
	{
		log.debug("saving StockFuture instance");
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

	public void delete(StockFuture persistentInstance)
	{
		log.debug("deleting StockFuture instance");
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

	public StockFuture findById(hibernate.dao.StockFutureId id)
	{
		log.debug("getting StockFuture instance with id: " + id);
		try
		{
			StockFuture instance = (StockFuture) getHibernateTemplate().get("hibernate.dao.StockFuture", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StockFuture instance)
	{
		log.debug("finding StockFuture instance by example");
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
		log.debug("finding StockFuture instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from StockFuture as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all StockFuture instances");
		try
		{
			String queryString = "from StockFuture";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public StockFuture merge(StockFuture detachedInstance)
	{
		log.debug("merging StockFuture instance");
		try
		{
			StockFuture result = (StockFuture) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StockFuture instance)
	{
		log.debug("attaching dirty StockFuture instance");
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

	public void attachClean(StockFuture instance)
	{
		log.debug("attaching clean StockFuture instance");
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

	public static StockFutureDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (StockFutureDAO) ctx.getBean("StockFutureDAO");
	}
}