package hibernate.dao.ex;

import hibernate.dao.stock.StockArrange;
import hibernate.dao.stock.StockProcess;
import java.util.List;

public class StockArrangeDAO extends hibernate.dao.stock.StockArrangeDAO
{
	
	private StockProcessDAO processDAO;
	
	

	public StockProcessDAO getProcessDAO()
	{
		return processDAO;
	}



	public void setProcessDAO(StockProcessDAO processDAO)
	{
		this.processDAO = processDAO;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<?> findAll()
	{
		List<?> list = super.findAll();
		for (int i = 0; i < list.size(); i++)
		{
			StockArrange stock = (StockArrange)list.get(i);
			
			List<?> processes = processDAO.findByItemId(stock.getItemId());
			stock.setProcesses((List<StockProcess>)processes);
		}
		return list;
	}

}
