package struts.validator;

import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;
import hibernate.dao.Bom;
import hibernate.dao.ex.BomDAO;

public class BomValidator extends AbstractValidator
{

	private BomDAO dao;

	public BomDAO getDao()
	{
		return dao;
	}

	public void setDao(BomDAO dao)
	{
		this.dao = dao;
	}

	public Valid insert(Object object)
	{
		Bom bom = (Bom) object;
		if (dao.hasCode(bom.getCode()))
			return new Valid(false, 1, "insert.codeisexit");
		else
			return new Valid(true);
	}

	public Valid update(Object object)
	{
		Bom bom = (Bom) object;
		if (dao.hasCode(bom.getCode(), bom.getId()))
			return new Valid(false, 1, "insert.codeisexit");
		else if (bom.getCode() == null||bom.getCode().equals("")) {
			return new Valid(false, 2, "insert.codeisnull");
		}else if (dao.hasNumero(bom.getNumero(), bom.getId())) {
			return new Valid(false, 3, "insert.numeroisexit");
		}else if (bom.getNumero() == null||bom.getNumero().equals("")) {
			return new Valid(false, 4, "insert.numeroisnull");
		}
			return new Valid(true);
	}

	public Valid merge(Object object)
	{
		Bom bom = (Bom) object;
		if (bom.getId() == null || bom.getId() == 0)
			return insert(bom);
		else
			return update(bom);
	}

	public Valid delete(Object instance)
	{
		return null;
	}

}
