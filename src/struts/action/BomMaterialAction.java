package struts.action;

import hibernate.dao.BomMaterial;
import hibernate.dao.ex.BomMaterialDAO;

import java.io.IOException;

import juinfo.struts2.action.ListAction;
import net.sf.json.JSONArray;

public class BomMaterialAction extends ListAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2414239773081247656L;

	private BomMaterial pojo;
	private BomMaterialDAO dao;

	/*
	 * action mehtods
	 */
	
	@Override
	public boolean isInsert()
	{
		return pojo == null || pojo.getId() == 0;
	}

	public BomMaterial getPojo()
	{
		return pojo;
	}

	public void setPojo(BomMaterial pojo)
	{
		this.pojo = pojo;
	}

	public BomMaterialAction(BomMaterialDAO dao)
	{
		super(dao);
		this.dao = dao;
	}

	public String list()
	{
		dataList = dao.findByParentId(pojo.getParentId());
		return LIST;
	}

	public String search()
	{
		dataList = dao.searchByParentId(pojo.getParentId(), searchContext);
		return LIST;
	}

	public void findByParentId() throws IOException
	{
		dataList = dao.findByParentId(pojo.getParentId());
        JSONArray json = JSONArray.fromObject(dataList);
        getResponse().getWriter().print(json);
	}
}
