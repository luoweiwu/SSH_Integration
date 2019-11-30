package com.Gary.web;

import com.Gary.domain.User;
import com.Gary.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	public User user = new User();

	private UserService userService;
	
	public String execute() throws Exception {
			
		boolean success = userService.findUser(user);
		
		if(success)
		{
			return "toIndex";
		}else {
			ActionContext.getContext().put("error", "用户名或密码错误！！！");
			return "login";
		}
		
	}

	
	
	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@Override
	public User getModel() {
		return user;
	}

}
