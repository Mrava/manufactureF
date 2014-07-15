package struts.validator;

import hibernate.dao.ex.MaterialPlanDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class MaterialPlanValidator  extends AbstractValidator
{
	private MaterialPlanDAO materialPlanDAO;

	public MaterialPlanDAO getMaterialPlanDAO()
	{
		return materialPlanDAO;
	}

	public void setMaterialPlanDAO(MaterialPlanDAO materialPlanDAO)
	{
		this.materialPlanDAO = materialPlanDAO;
	}

	public Valid insert(Object instance)  
	{
		return Valid.passed();
	}

	public Valid merge(Object instance)
	{
		return Valid.passed();
	}

	public Valid update(Object instance)
	{
		return Valid.passed();
	}

	public Valid delete(Object instance)
	{
		return Valid.passed();
	}
	
	
	
}
