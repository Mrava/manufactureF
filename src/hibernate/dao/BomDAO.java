package hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for Bom
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hibernate.dao.Bom
 * @author MyEclipse Persistence Tools
 */

public class BomDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(BomDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String REMARK = "remark";
	public static final String NUMERO = "numero";
	public static final String TYPE_ID = "typeId";
	public static final String SORT = "sort";

	protected void initDao()
	{
		// do nothing
	}

	public void save(Bom transientInstance)
	{
		log.debug("saving Bom instance");
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

	public void delete(Bom persistentInstance)
	{
		log.debug("deleting Bom instance");
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

	public Bom findById(java.lang.Integer id)
	{
		log.debug("getting Bom instance with id: " + id);
		try
		{
			Bom instance = (Bom) getHibernateTemplate().get("hibernate.dao.Bom", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bom instance)
	{
		log.debug("finding Bom instance by example");
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
		log.debug("finding Bom instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from Bom as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCode(Object code)
	{
		return findByProperty(CODE, code);
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByRemark(Object remark)
	{
		return findByProperty(REMARK, remark);
	}

	public List findByNumero(Object numero)
	{
		return findByProperty(NUMERO, numero);
	}

	public List findByTypeId(Object typeId)
	{
		return findByProperty(TYPE_ID, typeId);
	}

	public List findBySort(Object sort)
	{
		return findByProperty(SORT, sort);
	}

	public List findAll()
	{
		log.debug("finding all Bom instances");
		try
		{
			String queryString = "from Bom";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bom merge(Bom detachedInstance)
	{
		log.debug("merging Bom instance");
		try
		{
			Bom result = (Bom) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bom instance)
	{
		log.debug("attaching dirty Bom instance");
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

	public void attachClean(Bom instance)
	{
		log.debug("attaching clean Bom instance");
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

	public static BomDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (BomDAO) ctx.getBean("BomDAO");
	}
}