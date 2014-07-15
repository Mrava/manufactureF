package struts.action;

import hibernate.dao.User;
import hibernate.dao.ex.UserDAO;
import juinfo.paper.Paper;
import juinfo.struts2.action.ListAction;
@SuppressWarnings("serial")
public class UserAction extends ListAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private User pojo;
//	private UserDAO dao;

	public User getPojo()
	{
		return (User)super.pojo;
	}

	public void setPojo(User pojo)
	{
		this.pojo = pojo;
	}

//	public UserDAO getDao()
//	{
//		return dao;
//	}
//
//	public void setDao(UserDAO dao)
//	{
//		this.dao = dao;
//	}

//	@Override
//	public boolean isInsert()
//	{
//		return pojo == null || pojo.getId() == 0;
//	}
	
	public UserDAO getCaseDao() {
		return (UserDAO)getDao();
	}
	
	/*
	 * **************************** Action Methods ************************
	 */
	public String list()
	{
		if (paper == null || paper.getCount() == 0)
		{
//			Integer count = getDao().getListCount().intValue();
			//Integer count = dao.getListCount().intValue();
			Integer count = getCaseDao().getListCount().intValue();
			paper = new Paper(count, Paper.SIZE);
			dataList = getCaseDao().findList(paper.getStart(), paper.getSize());
		} else
		{
			paper.setSize(Paper.SIZE);
			dataList = getCaseDao().findList(paper.getStart(), paper.getSize());
		}
		return LIST;
	}

	public String search()
	{
		if (paper == null || paper.getCount() == 0)
		{
			Integer count = getCaseDao().getLikeCount(searchContext).intValue();
			paper = new Paper(count, Paper.SIZE);
			dataList = getCaseDao().likeByUserName(searchContext, paper.getStart(), paper.getSize());
		} else
		{
			paper.setSize(Paper.SIZE);
			dataList = getCaseDao().likeByUserName(searchContext, paper.getStart(), paper.getSize());
		}
		return LIST;
	}

	public String add()
	{
		return ADD;
	}

//	public String edit()
//	{
//		pojo = getCaseDao().findById(pojo.getId());
//		return EDIT;
//	}

//	public String delete()
//	{
//		pojo = getCaseDao().findById(pojo.getId());
//		getCaseDao().delete(pojo);
//		setMessage(new ActionMessage(DELETE, 0, "delete success"));
//		return list();
//	}

//	public String save()
//	{
//		getCaseDao().merge(pojo);
//		setMessage(new ActionMessage(SAVE, 0, "insert success"));
//
//		return EDIT;
//	}

}
