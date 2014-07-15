package struts.validator;

import hibernate.dao.ex.ProviderDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class ProviderValidator extends AbstractValidator
{
	private ProviderDAO providerDAO;

	public ProviderDAO getProviderDAO()
	{
		return providerDAO;
	}

	public void setProviderDAO(ProviderDAO providerDAO)
	{
		this.providerDAO = providerDAO;
	}

	public Valid isRightName(String name)
	{
		if (providerDAO.findByName(name).size() > 0)
		{
			return new Valid(false, 1, "insert.providerisexit");
		} else
		{
			return new Valid(true);
		}
	}

	public Valid insert(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid merge(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid update(Object instance)
	{
		return null;
	}

	public Valid delete(Object instance)
	{
		return null;
	}
}
