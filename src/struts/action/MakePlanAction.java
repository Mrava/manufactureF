package struts.action;

import java.util.Date;
import java.util.List;
import hibernate.dao.MakeMaterial;
import hibernate.dao.MakePlan;
import hibernate.dao.ex.MakeMaterialDAO;
import hibernate.dao.ex.MakePlanDAO;
import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class MakePlanAction extends ListAction
{

	private List<MakeMaterial> materials;
	private MakeMaterialDAO materialDAO;

	public MakePlan getPojo()
	{
		return (MakePlan) super.pojo;
	}

	public void setPojo(MakePlan pojo)
	{
		this.pojo = pojo;
	}

	public MakeMaterialDAO getMaterialDAO()
	{
		return materialDAO;
	}

	public void setMaterialDAO(MakeMaterialDAO materialDAO)
	{
		this.materialDAO = materialDAO;
	}

	public List<MakeMaterial> getMaterials()
	{
		return materials;
	}

	public void setMaterials(List<MakeMaterial> materials)
	{
		this.materials = materials;
	}

	public MakePlanDAO getCaseDao()
	{
		return (MakePlanDAO) getDao();
	}

	/*
	 * action.methods.
	 */

	public String add()
	{
		MakePlan plan = new MakePlan();
		plan.setTdate(new Date());
		pojo = plan;
		return ADD;
	}

	public String edit()
	{
		pojo = getCaseDao().findById(getPojo().getId());
		materials = materialDAO.findByIndexId(getPojo().getId());
		return EDIT;
	}

	public String insert()
	{
		pojo = getCaseDao().merge(getPojo());
		materialDAO.saveList(materials, getPojo().getId());
		return ADD;
	}

	public String update()
	{
		pojo = getCaseDao().merge(getPojo());
		materialDAO.saveList(materials, getPojo().getId());
		return list();
	}

	public String delete()
	{
		pojo = getCaseDao().findById(getPojo().getId());
		materialDAO.deleteByIndexId(getPojo().getId());
		getCaseDao().delete(getPojo());
		return list();
	}

}
