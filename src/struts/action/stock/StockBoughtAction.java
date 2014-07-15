package struts.action.stock;

import hibernate.dao.StockBillItem;

import java.util.Date;


@SuppressWarnings("serial")
public class StockBoughtAction extends StockBillItemAction
{

	@Override
	public void prepare() throws Exception
	{
		billType = BillType.STOCK_BOUGHT;
		super.prepare();
	}
	

}
