package struts.validator;

import juinfo.validation.Valid;
import juinfo.validation.AbstractValidator;
import hibernate.dao.BomRelation;
import hibernate.dao.ex.BomRelationDAO;

public class BomRelationValidator extends AbstractValidator
{
	private BomRelationDAO bomRelationDAO;

	
	public BomRelationDAO getBomRelationDAO()
	{
		return bomRelationDAO;
	}

	public void setBomRelationDAO(BomRelationDAO bomRelationDAO)
	{
		this.bomRelationDAO = bomRelationDAO;
	}

	public Valid insert(Object instance)
	{  
		
//		BomRelation bomRelation = (BomRelation)instance;
//		if (bomRelationDAO.hasCode(bomRelation.getCode(), bomRelation.getItem()))
//			return new Valid(false, 1, "insert.codeisexit");
//		else
//			return new Valid(true);
		return new Valid(true);
	}

	public Valid update(Object instance)
	{
//		BomRelation bomRelation = (BomRelation)instance;
//		if (bomRelationDAO.hasCode(bomRelation.getCode(), bomRelation.getItem(), bomRelation.getId()))
//			return new Valid(false, 1, "insert.codeisexit");
//		else
//			return new Valid(true);
		return new Valid(true);
	}
	
	public Valid merge(Object instance)
	{
		BomRelation bomRelation = (BomRelation)instance;
		if (bomRelation.getId() == null || bomRelation.getId() == 0)
			return insert(bomRelation);
		else
			return update(bomRelation);
	}

	public Valid delete(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
