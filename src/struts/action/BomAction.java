package struts.action;

import java.util.List;
import juinfo.struts2.action.ListAction;
import net.sf.json.JSONArray;
import hibernate.dao.Bom;
import hibernate.dao.ex.BomDAO;
import hibernate.dao.ex.BomTypeDAO;

@SuppressWarnings("serial")
public class BomAction extends ListAction
{
	/*
	 * Fields
	 */
	private BomTypeDAO typeDAO;
	private List<?> typeList;

	public Bom getPojo()
	{
		return (Bom) super.pojo;
	}

	public void setPojo(Bom bom)
	{
		super.pojo = bom;
	}

	public List<?> getTypeList()
	{
		return typeList;
	}

	public void setTypeList(List<?> typeList)
	{
		this.typeList = typeList;
	}

	public BomTypeDAO getTypeDAO()
	{
		return typeDAO;
	}

	public void setTypeDAO(BomTypeDAO typeDAO)
	{
		this.typeDAO = typeDAO;
	}

	public BomDAO getCaseDao()
	{
		return (BomDAO) getDao();
	}

	/*
	 * ************************** Action Methods ********************
	 */

	@Override
	public void prepare() throws Exception
	{
		typeList = typeDAO.findAll();
		super.prepare();
	}

	public void indexByCode() throws Exception
	{
		List<?> list = getCaseDao().likeByCode(searchContext, 10);
		JSONArray json = JSONArray.fromObject(list);
		getResponse().getWriter().print(json);
	}

	public void indexByNumero() throws Exception
	{
		List<?> list = getCaseDao().likeByNumero(searchContext, 10);
		JSONArray json = JSONArray.fromObject(list);
		getResponse().getWriter().print(json);
	}

	public void indexByName() throws Exception
	{
		List<?> list = getCaseDao().likeByName(searchContext, 10);
		JSONArray json = JSONArray.fromObject(list);
		getResponse().getWriter().print(json);
	}

	public void getIdByCode() throws Exception
	{
		List<?> list = getCaseDao().findByCode(searchContext);
		String context = "";
		if (list.size() == 0)
			context = "0,0,,,";
		else
		{
			Bom bom = (Bom) list.get(0);
			context = String.format("%d,%d,%s,%s,%s", list.size(), bom.getId(), bom.getNumero(), bom.getCode(),
					bom.getName());
		}
		getResponse().getWriter().print(context);
	}
	
	public int getBomIdByCode() throws Exception
	{
		List<?> list = getCaseDao().findByCode(searchContext);
		String context = "";
		if (list.size() == 0)
			context = "0,0,,,";
		else
		{
			Bom bom = (Bom) list.get(0);
			context = String.format("%d,%d,%s,%s,%s", list.size(), bom.getId(), bom.getNumero(), bom.getCode(),
					bom.getName());
		}
		getResponse().getWriter().print(context);
		return 11;
	}

	
	public void getIdByNumero() throws Exception
	{
		List<?> list = getCaseDao().findByCode(searchContext);
		String context = "";
		if (list.size() == 0)
			context = "0,0,,,";
		else
		{
			Bom bom = (Bom) list.get(0);
			context = String.format("%d,%d,%s,%s,%s", list.size(), bom.getId(), bom.getNumero(), bom.getCode(),
					bom.getName());
		}
		getResponse().getWriter().print(context);
	}

}
