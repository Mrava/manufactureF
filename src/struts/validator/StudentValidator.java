package struts.validator;

import hibernate.dao.Student;
import hibernate.dao.ex.StudentDAO;
import juinfo.validation.AbstractValidator;
import juinfo.validation.Valid;

public class StudentValidator  extends AbstractValidator
{
	private StudentDAO studentDAO;

	public StudentDAO getStudentDAO()
	{
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}

	public Valid insert(Object instance)
	{
		Student student = (Student) instance;  
		if (student.getName() == null || student.getName().equals(""))
			return new Valid(false, 1);
		return new Valid(true);
	}

	public Valid merge(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid update(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public Valid delete(Object instance)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
