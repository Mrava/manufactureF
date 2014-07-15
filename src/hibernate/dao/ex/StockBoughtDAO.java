package hibernate.dao.ex;

import hibernate.dao.stock.StockBought;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import juinfo.paper.PaperHQL;

public class StockBoughtDAO extends hibernate.dao.stock.StockBoughtDAO implements PaperHQL
{

	@SuppressWarnings("unchecked")
	public List<StockBought> findByItemId_Tdate(Integer itemId, Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String strDate = format.format(date);
		String hql = String.format("from StockBought where itemId = %d and tdate >= to_date('%s', 'YYYYmmdd')", itemId,
				strDate);
		return (List<StockBought>) getHibernateTemplate().find(hql);
	}

	public String getHQLFind()
	{
		return "from StockBought order by tdate";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from StockBought";
	}

	public String getHQLSearch(String key)
	{
		//未做处理，查找与 getHQLFind 一样。
		return "from StockBought order by tdate";
	}

	public String getHQLSearchCount(String key)
	{
		return "select count(*) from StockBought";
	}

}
