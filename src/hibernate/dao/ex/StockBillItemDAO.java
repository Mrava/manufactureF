package hibernate.dao.ex;

import juinfo.paper.PaperHQL;

public class StockBillItemDAO extends hibernate.dao.StockBillItemDAO implements PaperHQL 
{

	public String getHQLFind()
	{
		return "from StockBillItem order by tdate";
	}

	public String getHQLFindCount()
	{
		return "select count(*) from StockBillItem";
	}

	public String getHQLSearch(String key)
	{
		return String.format("from StockBillItem where bom.name like '%%%s%%' order by tdate", key);
	}

	public String getHQLSearchCount(String key)
	{
		return String.format("select count(*)from StockBillItem where bom.name like '%%%s%%'", key);
	}

	
}
