package struts.action;

import hibernate.dao.MaterialPlan;
import hibernate.dao.ex.MaterialPlanDAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import juinfo.struts2.action.ListAction;

@SuppressWarnings("serial")
public class MaterialPlanAction extends ListAction
{

	private List<MaterialPlan> pojos;

	public MaterialPlan getPojo()
	{
		return (MaterialPlan) super.pojo;
	}

	public void setPojo(MaterialPlan plan)
	{
		super.pojo = plan;
	}

	public List<MaterialPlan> getPojos()
	{
		return pojos;
	}

	public void setPojos(List<MaterialPlan> pojos)
	{
		this.pojos = pojos;
	}

	public MaterialPlanDAO getCaseDao()
	{
		return (MaterialPlanDAO) getDao();
	}

	/*
	 * Action.methos
	 */

	public String add()
	{
		MaterialPlan plan = new MaterialPlan();
		plan.setTdate(new Date());
		super.pojo = plan;
		return ADD;
	}

	public String addBatch()
	{
		MaterialPlan plan = new MaterialPlan();
		plan.setTdate(new Date());
		super.pojo = plan;
		return "addBatch";
	}

	public String insertBatch()
	{
		for (int i = 0; i < pojos.size(); i++)
		{
			MaterialPlan plan = pojos.get(i);
			if (getCaseDao().hasRecord(plan.getBomId(), plan.getTdate()))
				getCaseDao().delete(plan.getBomId(), plan.getTdate());
			plan.setBom(null);
			getCaseDao().save(plan);
		}
		return list();
	}

}
