package struts.action;

import java.io.IOException;
import juinfo.struts2.action.ListAction;
import hibernate.dao.Student;

@SuppressWarnings("serial")
public class StudentAction extends ListAction
{

	public Student getPojo()
	{
		return (Student) super.pojo;
	}

	public void setPojo(Student pojo)
	{
		super.pojo = pojo;
	}

	/*
	 * action.methods.
	 */
	public String execute()
	{
		return SUCCESS;
	}

	public void ajax() throws IOException
	{
		getResponse().getWriter().print(getPojo().getName() + getPojo().getRemark());
	}

}