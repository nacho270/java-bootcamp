package com.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Business.ControlMarket;
import com.Business.User;
import com.Services.Mapper;
import com.Services.ShoppingCart;

@Controller
@ComponentScan("com.Business")
public class ControllerLogin {

	@Autowired
	private ControlMarket controlMarket;
	
	@Autowired
	private Mapper map;

	public ControllerLogin() {

	}
	
	@RequestMapping("/")
	public String home(){
		return "hello maven with spring";
	}
	
	@RequestMapping(value ="/userExample", method = RequestMethod.GET)
	@ResponseBody
	public User ShowUser(){
		return new User("matias","38039141");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String showLogin(){
		return "login";}
	
	
	@ResponseBody
	@RequestMapping(value ="/login/Submit", method = RequestMethod.POST)
	public String submitUser( @RequestBody User user){
		if(this.controlMarket.exist(user)){
			ShoppingCart scart = new ShoppingCart();
			user.setCart(scart);
			return "User valid!!"+ "Id:"+map.addUser(user);
		}
		return "Invalid User";
	}
	

}
