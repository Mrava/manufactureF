package hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * BomType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.dao.BomType
 * @author MyEclipse Persistence Tools
 */

public class BomTypeDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(BomTypeDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String REMARK = "remark";

	protected void initDao()
	{
		// do nothing
	}

	public void save(BomType transientInstance)
	{
		log.debug("saving BomType instance");
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

	public void delete(BomType persistentInstance)
	{
		log.debug("deleting BomType instance");
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

	public BomType findById(java.lang.Integer id)
	{
		log.debug("getting BomType instance with id: " + id);
		try
		{
			BomType instance = (BomType) getHibernateTemplate().get("hibernate.dao.BomType", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BomType instance)
	{
		log.debug("finding BomType instance by example");
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
		log.debug("finding BomType instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from BomType as model where model." + propertyName + "= ?";
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

	public List findByRemark(Object remark)
	{
		return findByProperty(REMARK, remark);
	}

	public List findAll()
	{
		log.debug("finding all BomType instances");
		try
		{
			String queryString = "from BomType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public BomType merge(BomType detachedInstance)
	{
		log.debug("merging BomType instance");
		try
		{
			BomType result = (BomType) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BomType instance)
	{
		log.debug("attaching dirty BomType instance");
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

	public void attachClean(BomType instance)
	{
		log.debug("attaching clean BomType instance");
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

	public static BomTypeDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BomTypeDAO) ctx.getBean("BomTypeDAO");
	}
}