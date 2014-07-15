package hibernate.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * MaterialPlan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.dao.MaterialPlan
 * @author MyEclipse Persistence Tools
 */

public class MaterialPlanDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(MaterialPlanDAO.class);
	// property constants
	public static final String INDEX_ID = "indexId";
	public static final String BOM_ID = "bomId";
	public static final String QUANTITY = "quantity";

	protected void initDao()
	{
		// do nothing
	}

	public void save(MaterialPlan transientInstance)
	{
		log.debug("saving MaterialPlan instance");
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
	/**
	 * @author huangzhixia
	 * */
	public void update(MaterialPlan updateInstance) {

		try
		{
			getHibernateTemplate().update(updateInstance);
			log.debug("update successful");
		} catch (RuntimeException re)
		{
			log.error("update failed", re);
			throw re;
		}
	}
	
	public void delete(MaterialPlan persistentInstance)
	{
		log.debug("deleting MaterialPlan instance");
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

	public MaterialPlan findById(java.lang.Integer id)
	{
		log.debug("getting MaterialPlan instance with id: " + id);
		try
		{
			MaterialPlan instance = (MaterialPlan) getHibernateTemplate().get("hibernate.dao.MaterialPlan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MaterialPlan instance)
	{
		log.debug("finding MaterialPlan instance by example");
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
		log.debug("finding MaterialPlan instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from MaterialPlan as model where model." + propertyName + "= ?";
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
		log.debug("finding all MaterialPlan instances");
		try
		{
			String queryString = "from MaterialPlan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public MaterialPlan merge(MaterialPlan detachedInstance)
	{
		log.debug("merging MaterialPlan instance");
		try
		{
			MaterialPlan result = (MaterialPlan) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MaterialPlan instance)
	{
		log.debug("attaching dirty MaterialPlan instance");
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

	public void attachClean(MaterialPlan instance)
	{
		log.debug("attaching clean MaterialPlan instance");
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

	public static MaterialPlanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (MaterialPlanDAO) ctx.getBean("MaterialPlanDAO");
	}
}