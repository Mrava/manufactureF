package hibernate.dao.ex;

import org.hibernate.SessionFactory;
import juinfo.paper.PaperHQL;;

public class StockFutureDAO extends hibernate.dao.StockFutureDAO implements PaperHQL
{
	public StockFutureDAO(SessionFactory sessionFactory)
	{
		this.setSessionFactory(sessionFactory);
	}
	
	public String getHQLFind()
	{
		return "from StockFuture order by bom.code";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from StockFuture";
	}

	public String getHQLSearch(String key)
	{
		return String.format("from StockFuture where bom.code like '%%%s%%' order by bom.code", key);
	}

	public String getHQLSearchCount(String key)
	{
		return String.format("select count(*) from StockFuture where bom.code like '%%%s%%'", key);
	}

}
