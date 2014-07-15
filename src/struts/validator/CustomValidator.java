package struts.validator;

import hibernate.dao.Custom;
import hibernate.dao.ex.CustomDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class CustomValidator  extends AbstractValidator
{
	private CustomDAO customDAO;

	public CustomDAO getCustomDAO()
	{
		return customDAO;
	}

	public void setCustomDAO(CustomDAO customDAO)
	{
		this.customDAO = customDAO;
	}  

	public Valid insert(Object instance)
	{
		Custom custom = (Custom)instance;
		if (customDAO.isRightName(custom.getName()) == false)
			return new Valid(false, 1, "insert.customisexit");
		return new Valid(true);
	}

	public Valid merge(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid update(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid delete(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
