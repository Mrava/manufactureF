package struts.action;

import hibernate.dao.ex.StockArrangeDAO;
import juinfo.struts2.action.ListAction;

public class StockArrangeAction extends ListAction
{

	public StockArrangeDAO getCaseDAO()
	{
		return (StockArrangeDAO) getDao();
	}
	
	@Override
	public String list()
	{
		dataList = getCaseDAO().findAll();
		return LIST;
	}
	
}
