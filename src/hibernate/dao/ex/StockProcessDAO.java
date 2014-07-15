package hibernate.dao.ex;

import java.util.List;

public class StockProcessDAO extends hibernate.dao.stock.StockProcessDAO
{
	
	public List<?> findByItemId(Integer itemId)
	{
		String hql = String.format("from StockProcess where itemId = %d", itemId);
		return getHibernateTemplate().find(hql);
	}

}
