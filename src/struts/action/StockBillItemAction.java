package struts.action;

import java.util.List;

import hibernate.dao.StockBillItem;
import hibernate.dao.ex.StockBillItemDAO;
import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class StockBillItemAction extends ListAction
{
	private List<StockBillItem> pojos;

	public List<StockBillItem> getPojos()
	{
		return pojos;
	}

	public void setPojos(List<StockBillItem> pojos)
	{
		this.pojos = pojos;
	}

	public StockBillItem getPojo()
	{
		return (StockBillItem) super.pojo;
	}

	public void setPojo(StockBillItem item)
	{
		super.pojo = item;
	}

	public StockBillItemDAO getCaseDao()
	{
		return (StockBillItemDAO) getDao();
	}

	/*
	 * ******************* Action.Mehthods ***************
	 */

	public String insertBatch()
	{
		for (int i = 0; i < pojos.size(); i++)
		{
			StockBillItem item = (StockBillItem) pojos.get(i);
			item.setBom(null);
			getCaseDao().save(item);
		}
		return LIST;
	}
}
