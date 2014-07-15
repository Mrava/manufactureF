package struts.intercepor;

import juinfo.spring.SpringBeanFactory;
import juinfo.struts2.action.ActionMessage;
import juinfo.struts2.action.ListAction;
import juinfo.validation.DMLValidator;
import juinfo.validation.Valid;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 主要处理保存前数据判断, ActionMessage的设置
 * 
 * @author bridge
 * */
@SuppressWarnings("serial")
public class ListInterceptor extends MethodFilterInterceptor
{

	private String name;
	private String validatorClass;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValidatorClass()
	{
		return validatorClass;
	}

	public void setValidatorClass(String validatorClass)
	{
		this.validatorClass = validatorClass;
	}

	private DMLValidator getValidator()
	{
		if (SpringBeanFactory.getContext() == null)
			SpringBeanFactory.load("applicationContext.xml");
		if (validatorClass != null && validatorClass != "")
			return (DMLValidator) SpringBeanFactory.getBean(validatorClass);
		else
			return null;
	}

	/**
	 * 设置 message; <br>
	 * 数据判断有误时转向; <br>
	 * 
	 * */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		String method = invocation.getProxy().getMethod();
		ListAction action = (ListAction) invocation.getAction();

		ActionMessage message = new ActionMessage(method);
		Valid valid = validate(method, action);
		if (valid != null)
		{
			message.setError(valid.getError());
			message.setMessage(valid.getMessage());
		}
		action.setMessage(message);

		if (valid != null && !valid.isPassed())
			return failResult(method);

		return invocation.invoke();
	}

	private Valid validate(String method, ListAction action)
	{
		DMLValidator validator = getValidator();
		Object pojo = action.getActionPojo();

		if (method.equals(ListAction.SAVE))
		{
			if (action.isInsert())
				return validator.insert(pojo);
			else
				return validator.update(pojo);
		} else if (method.equals(ListAction.INSERT))
			return validator.insert(pojo);
		else if (method.equals(ListAction.UPDATE))
			return validator.update(pojo);
		else if (method.equals(ListAction.DELETE))
			return validator.delete(pojo);
		else
			return null;
	}

	private String failResult(String method)
	{
		if (method.equals(ListAction.SAVE))
			return ListAction.EDIT;
		else if (method.equals(ListAction.INSERT))
			return ListAction.EDIT;
		else if (method.equals(ListAction.UPDATE))
			return ListAction.EDIT;
		else if (method.equals(ListAction.DELETE))
			return ListAction.LIST;
		else
			return null;
	}
}
