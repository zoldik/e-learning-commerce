package com.elearning.interceptors;


import java.util.List;
import java.util.Map;

import org.elearning.entities.User;
import org.elearning.entities.UserInterface;

import com.elearning.front.actions.LoginAction;
import com.elearning.front.actions.LoginRequired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		List<String> roles = (List<String>) session.get("roles");
		User user = (User) session.get("user");
		if(user instanceof UserInterface){
			return invocation.invoke();
		}
		Object action = invocation.getAction();
		
		if(!(action instanceof LoginRequired)){
			return invocation.invoke();
		}
		
		if (!(action instanceof LoginAction)) {
            return "loginRedirect";
        }
		
		return invocation.invoke();
	}

}
