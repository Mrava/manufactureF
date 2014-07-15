package struts.action.stock;

import hibernate.dao.StockBillItem;
import hibernate.dao.ex.StockBillItemDAO;

import java.util.Date;
import java.util.List;

import juinfo.paper.Paper;
import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class StockBillItemAction extends ListAction
{
	protected int billType;

	public int getBillType()
	{
		return billType;
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

	protected List<StockBillItem> pojos;

	public List<StockBillItem> getPojos()
	{
		return pojos;
	}

	public void setPojos(List<StockBillItem> pojos)
	{
		this.pojos = pojos;
	}

	/*
	 * ******************* Action.Mehthods ***************
	 */


	public String add()
	{
		StockBillItem item = new StockBillItem();
		item.setTdate(new Date());
		item.setTypeId(billType);
		super.pojo = item;
		return ADD;
	}

	public String addBatch()
	{
		return ADDBATCH;
	}

	public String list()
	{
		dataList = getCaseDao().findByTypeId(billType);
		//未处理分页
		paper = new Paper(0, 0);
		return LIST;
	}

	@Override
	public String insert()
	{
		getPojo().setTypeId(billType);
		return super.insert();
	}
	@Override
	public String update()
	{
		getPojo().setTypeId(billType);
		return super.update();
	}
	
	public String insertBatch()
	{
		for (int i = 0; i < pojos.size(); i++)
		{
			StockBillItem item = (StockBillItem) pojos.get(i);
			item.setBom(null);
			item.setTypeId(billType);
			getCaseDao().save(item);
		}
		return LIST;
	}
}
