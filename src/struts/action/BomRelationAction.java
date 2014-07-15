package struts.action;

import hibernate.dao.Bom;
import hibernate.dao.BomRelation;
import hibernate.dao.ex.BomDAO;
import hibernate.dao.ex.BomRelationDAO;
import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class BomRelationAction extends ListAction
{
	private BomDAO bomDAO;

	public BomDAO getBomDAO()
	{
		return bomDAO;
	}

	public void setBomDAO(BomDAO bomDAO)
	{
		this.bomDAO = bomDAO;
	}

	public BomRelation getPojo()
	{
		return (BomRelation)pojo;
	}

	public void setPojo(BomRelation pojo)
	{
		super.pojo = pojo;
	}
	
	public BomRelationDAO getCaseDao()
	{
		return (BomRelationDAO) getDao();
	}

	/*
	 *************************** action.methods.
	 */
	
	public String list()
	{
		dataList = getCaseDao().findByParentId(getPojo().getParentId());
		return LIST;
	}

	public String search()
	{
		dataList = getCaseDao().searchByParentId(getPojo().getParentId(), searchContext);
		return LIST;
	}

	public String add()
	{
		Bom parent = bomDAO.findById(getPojo().getParentId());
		getPojo().setParent(parent);
		return ADD;
	}
	
	public String insert()
	{
		Bom parent = bomDAO.findById(getPojo().getParentId());
		super.insert();
		getPojo().setParentId(parent.getId());
		getPojo().setParent(parent);
		bomDAO.calcMaterial(parent.getId());
		return EDIT;
	}
	
	@Override
	public String update()
	{
		String result = super.update();
		bomDAO.calcMaterial(getPojo().getParentId());
		return result;
	}
	
}
