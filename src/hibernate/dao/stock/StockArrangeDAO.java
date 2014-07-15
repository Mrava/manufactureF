package hibernate.dao.stock;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for StockArrange entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see hibernate.dao.stock.StockArrange
  * @author MyEclipse Persistence Tools 
 */

public class StockArrangeDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(StockArrangeDAO.class);
		//property constants



	protected void initDao() {
		//do nothing
	}
    
    public void save(StockArrange transientInstance) {
        log.debug("saving StockArrange instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(StockArrange persistentInstance) {
        log.debug("deleting StockArrange instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StockArrange findById( hibernate.dao.stock.StockArrange id) {
        log.debug("getting StockArrange instance with id: " + id);
        try {
            StockArrange instance = (StockArrange) getHibernateTemplate()
                    .get("hibernate.dao.stock.StockArrange", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(StockArrange instance) {
        log.debug("finding StockArrange instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding StockArrange instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StockArrange as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all StockArrange instances");
		try {
			String queryString = "from StockArrange";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public StockArrange merge(StockArrange detachedInstance) {
        log.debug("merging StockArrange instance");
        try {
            StockArrange result = (StockArrange) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StockArrange instance) {
        log.debug("attaching dirty StockArrange instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StockArrange instance) {
        log.debug("attaching clean StockArrange instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StockArrangeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StockArrangeDAO) ctx.getBean("StockArrangeDAO");
	}
}