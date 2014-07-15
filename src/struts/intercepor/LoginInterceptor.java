package struts.intercepor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor
{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		Object user = invocation.getInvocationContext().getSession().get("session.user");
		if (user != null)
			return invocation.invoke();
		else
			return Action.LOGIN;
	}

}
