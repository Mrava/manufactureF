package struts.validator;

import hibernate.dao.ex.MakePlanDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class MakePlanValidator  extends AbstractValidator
{
	private MakePlanDAO makePlanDAO;

	public MakePlanDAO getMakePlanDAO()
	{
		return makePlanDAO;
	}

	public void setMakePlanDAO(MakePlanDAO makePlanDAO)
	{
		this.makePlanDAO = makePlanDAO;
	}
  
	public Valid insert(Object instance)
	{
		//MakePlan makePlan = (MakePlan)instance;
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
