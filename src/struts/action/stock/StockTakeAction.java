package struts.action.stock;

import hibernate.dao.StockBillItem;

public class StockTakeAction extends StockBillItemAction
{

	@Override
	public void prepare() throws Exception
	{
		billType = BillType.STOCK_TAKE;
		super.prepare();
	}
}
