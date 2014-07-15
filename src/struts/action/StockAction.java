package struts.action;

import hibernate.dao.Stock;
import hibernate.dao.ex.StockDAO;
import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class StockAction extends ListAction
{
	
	public Stock getPojo()
	{
		return (Stock)super.pojo;
	}

	public void setPojo(Stock pojo)
	{
		super.pojo = pojo;
	}

	public StockDAO getCaseDao()
	{
		return (StockDAO) getDao();
	}
	
	/*
	 * action methods
	 */


}
