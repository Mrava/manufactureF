package struts.validator;

import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;
import hibernate.dao.Stock;
import hibernate.dao.ex.StockDAO;

public class StockValidator  extends AbstractValidator
{
	private StockDAO dao;

	public StockDAO getDao()
	{
		return dao;
	}

	public void setDao(StockDAO dao)
	{
		this.dao = dao;
	}
	
	
	public Valid insert(Object instance)
	{  
		Stock stock = (Stock)instance;
		if (dao.hasBom(stock.getBomId()))
			return Valid.unPassed(1);
		else
			return Valid.passed();
	}
	
	public Valid update(Object instance)
	{
		Stock stock = (Stock)instance;
		if (dao.hasBom(stock.getBomId(), stock.getId()))
			return Valid.unPassed(1);
		else
			return Valid.passed();
	}
	
	public Valid merge(Object instance)
	{
		Stock stock = (Stock)instance;
		if (stock.getId() == null || stock.getId() == 0)
			return insert(stock);
		else
			return update(stock);
	}

	public Valid delete(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
