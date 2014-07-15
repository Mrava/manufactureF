package struts.action;

import java.util.List;
import java.util.Random;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import hibernate.dao.Menu;
import hibernate.dao.ex.MenuDAO;
import juinfo.hibernate.HibernatePojoCaller;
import juinfo.hibernate.PojoCaller;
import juinfo.spring.DaoCaller;
import juinfo.spring.HibernateDaoCaller;
import juinfo.struts2.action.ListAction;

public class EditMenuAction extends ListAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<?> menuList;
	private int parentId;
	
	
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public List<?> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<?> menuList) {
		this.menuList = menuList;
	}
	public Menu getPojo()
	{
		return (Menu) super.pojo;
	}
	public void setPojo(Menu menu)
	{
		super.pojo = menu;
	}
	public MenuDAO getCaseDao()
	{
		return (MenuDAO) getDao();
	}
	
	
	/**
	 * methods
	 * */
	
	public String list(){
		dataList=getCaseDao().getMenuName();
		menuList=getCaseDao().getMenuNames();
		return "success";
	}
	@Override
	public String add() {
		dataList=getCaseDao().getMenuName();
		return super.add();
	}
	
	@Override
	public String save() {
		
		System.out.println("getPojo().getId()===="+getPojo().getId());
		System.out.println("getPojo().getParentId()===="+getPojo().getParentId());
		System.out.println("getPojo().getIdX()===="+getPojo().getIdx());
		if (getPojo().getId() == null && getPojo().getParentId() > 0){
			return insertSed();
		}else if(getPojo().getId() == null && getPojo().getParentId() == 0){
			return insert();
		}else{
			return update();
		}
	}
	@Override
	public String update() {
		int idx=getCaseDao().getSedIdX(getPojo().getParentId());
		getPojo().setIdx(idx);
		return super.update();
	}
	
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		dataList=getCaseDao().getMenuName();
		return super.edit();
	}
	
	public String insertSed() {
		int idx=getCaseDao().getSedIdX(getPojo().getParentId());
		getPojo().setIdx(idx);
		int id=getCaseDao().getSedId(getPojo().getParentId());
		getPojo().setId(id);
		DaoCaller daoCaller = HibernateDaoCaller.getInstance(getDao());
		pojo = daoCaller.merge(pojo);
		try
		{
			pojo = pojo.getClass().newInstance();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return LIST;
	}
	@Override
	public String insert() {
		int idx=getCaseDao().getNewIdX();
		getPojo().setIdx(idx);
		int id=getCaseDao().getNewId();
		getPojo().setId(id);
		DaoCaller daoCaller = HibernateDaoCaller.getInstance(getDao());
		pojo = daoCaller.merge(pojo);
		try
		{
			pojo = pojo.getClass().newInstance();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return LIST;
	}
	

	public String dels(){
		System.out.println("getPojo().getParentId()==="+getPojo().getParentId());
		System.out.println("getCaseDao().getSedIdX(getPojo().getParentId()===="+getCaseDao().getSedIdX(getPojo().getParentId()));
		if(getPojo().getParentId() == 0){
			if(getCaseDao().getSedIdX(getPojo().getId()) == 1){
				return super.delete();
			}
		}
		return null;
		
	}

}
