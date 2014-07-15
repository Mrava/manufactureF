package struts.action;



import hibernate.dao.Menu;
import hibernate.dao.ex.MenuDAO;

import java.util.List;

import juinfo.struts2.action.ListAction;

public class MenuAction extends ListAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * Fields
	 */
	private List<?> list;
	private List<?> menuList;
	

	public Menu getPojo()
	{
		return (Menu) super.pojo;
	}

	public List<?> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<?> menuList) {
		this.menuList = menuList;
	}

	public void setPojo(Menu menu)
	{
		super.pojo = menu;
	}

	public List<?> getList()
	{
		return list;
	}

	public void setList(List<?> List)
	{
		this.list = List;
	}

	public MenuDAO getCaseDao()
	{
		return (MenuDAO) getDao();
	}
	
	/*
	 * ************************** Action Methods ********************
	 */
	public String findMenu(){
		list=getCaseDao().getMenuName();
		menuList=getCaseDao().getMenuNames();
		return "success";
	}
	
}
