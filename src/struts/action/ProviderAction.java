package struts.action;

import java.util.List;

import hibernate.dao.Provider;
import hibernate.dao.ex.ProviderDAO;
import struts.validator.ProviderValidator;
import juinfo.struts2.action.ActionMessage;
import juinfo.struts2.action.ListAction;
import juinfo.validation.Valid;

public class ProviderAction extends ListAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Provider getPojo() {
		return (Provider)super.pojo;
	}


	public void setPojo(Provider pojo) {
		super.pojo = pojo;
	}
	
	public ProviderDAO  getCaseDao(){
		return (ProviderDAO)getDao();
	}

	@Override
	public boolean isInsert()
	{
		return false;
	}


	/*
	 * action.methods.
	 */
	public String execute()
	{
		return SUCCESS;
	}

	/*public String list()
	{
		providerList = providerDAO.findAll();
		return LIST;
	}

	public String find()
	{
		providerList = providerDAO.likeByName(provider.getName());
		return LIST;
	}

	public String add()
	{
		return ADD;
	}

	public String edit()
	{
		provider = providerDAO.findById(provider.getId());
		return EDIT;
	}

	public String save()
	{
		Valid valid = validator.isRightName(provider.getName());
		if (!valid.isPassed())
		{
			setMessage(new ActionMessage(SAVE, valid.getError(), valid.getMessage()));
		} else
		{
			providerDAO.merge(provider);
			setMessage(new ActionMessage(SAVE, 0, "insert success"));
			provider.setId(null);
			provider.setName(null);
			provider.setRemark(null);
		}
		return EDIT;
	}

	public String delete()
	{
		provider = providerDAO.findById(provider.getId());
		providerDAO.delete(provider);
		setMessage(new ActionMessage(DELETE, 0, "delete success"));
		return list();
	}*/

}
