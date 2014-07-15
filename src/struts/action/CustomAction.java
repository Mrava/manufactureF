package struts.action;

import juinfo.struts2.action.ListAction;
import hibernate.dao.Custom;
import hibernate.dao.ex.CustomDAO;

public class CustomAction extends ListAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Custom getPojo()
	{
		return (Custom) super.pojo;
	}

	public void setPojo(Custom pojo)
	{
		super.pojo = pojo;
	}

	public CustomDAO getCaseDao()
	{
		return (CustomDAO) getDao();
	}

	/*
	 * action.methods.
	 */
	public String execute()
	{
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception
	{
		super.prepare();
	}

}
