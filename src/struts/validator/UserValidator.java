package struts.validator;

import hibernate.dao.ex.UserDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class UserValidator  extends AbstractValidator
{
	private UserDAO userDAO;

	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public Valid isRightName(String username)
	{
		if (userDAO.findByUsername(username).size() > 0)
		{  
			return new Valid(false, 1, "insert.usernameisexit");
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
		// TODO Auto-generated method stub
		return null;
	}

	public Valid delete(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
