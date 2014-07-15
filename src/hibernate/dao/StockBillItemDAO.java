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
 * StockBillItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.dao.StockBillItem
 * @author MyEclipse Persistence Tools
 */

public class StockBillItemDAO extends HibernateDaoSupport
{
	private static final Logger log = LoggerFactory.getLogger(StockBillItemDAO.class);
	// property constants
	public static final String ITEM_ID = "itemId";
	public static final String QUANTITY = "quantity";
	public static final String INDEX_ID = "indexId";
	public static final String RELATION_ID = "relationId";
	public static final String REMARK = "remark";
	public static final String CLIENT = "client";
	public static final String BILLNO = "billno";
	public static final String TYPE_ID = "typeId";

	protected void initDao()
	{
		// do nothing
	}

	public void save(StockBillItem transientInstance)
	{
		log.debug("saving StockBillItem instance");
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

	public void delete(StockBillItem persistentInstance)
	{
		log.debug("deleting StockBillItem instance");
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

	public StockBillItem findById(java.lang.Integer id)
	{
		log.debug("getting StockBillItem instance with id: " + id);
		try
		{
			StockBillItem instance = (StockBillItem) getHibernateTemplate().get("hibernate.dao.StockBillItem", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StockBillItem instance)
	{
		log.debug("finding StockBillItem instance by example");
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
		log.debug("finding StockBillItem instance with property: " + propertyName + ", value: " + value);
		try
		{
			String queryString = "from StockBillItem as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItemId(Object itemId)
	{
		return findByProperty(ITEM_ID, itemId);
	}

	public List findByQuantity(Object quantity)
	{
		return findByProperty(QUANTITY, quantity);
	}

	public List findByIndexId(Object indexId)
	{
		return findByProperty(INDEX_ID, indexId);
	}

	public List findByRelationId(Object relationId)
	{
		return findByProperty(RELATION_ID, relationId);
	}

	public List findByRemark(Object remark)
	{
		return findByProperty(REMARK, remark);
	}

	public List findByClient(Object client)
	{
		return findByProperty(CLIENT, client);
	}

	public List findByBillno(Object billno)
	{
		return findByProperty(BILLNO, billno);
	}

	public List findByTypeId(Object typeId)
	{
		return findByProperty(TYPE_ID, typeId);
	}

	public List findAll()
	{
		log.debug("finding all StockBillItem instances");
		try
		{
			String queryString = "from StockBillItem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public StockBillItem merge(StockBillItem detachedInstance)
	{
		log.debug("merging StockBillItem instance");
		try
		{
			StockBillItem result = (StockBillItem) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StockBillItem instance)
	{
		log.debug("attaching dirty StockBillItem instance");
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

	public void attachClean(StockBillItem instance)
	{
		log.debug("attaching clean StockBillItem instance");
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

	public static StockBillItemDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (StockBillItemDAO) ctx.getBean("StockBillItemDAO");
	}
}