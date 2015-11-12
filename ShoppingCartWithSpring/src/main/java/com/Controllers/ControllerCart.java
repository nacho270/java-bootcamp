package com.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Business.ControlMarket;
import com.Business.Item;
import com.Business.PayMode;
import com.Business.Transaction;
import com.Business.User;
import com.MessageFormat.ItemAdd;
import com.MessageFormat.UserBuy;
import com.Services.Mapper;

@Controller
@ComponentScan("com.Business")
public class ControllerCart {
	
	@Autowired
	private ControlMarket controlMarket;
	
	@Autowired
	private Mapper map;
	
	public ControllerCart() {
	}
	
	@RequestMapping(value = "/Item/add", method = RequestMethod.POST)
	@ResponseBody
	public String addItem(@RequestBody ItemAdd itemadd){
		
		int idUser = itemadd.getIdUser(); 
		if(this.map.existsUser(idUser)){
			Item item = this.controlMarket.getItemByName(itemadd.getNameItem());
			User user =this.map.getUserBy(idUser);
			user.getCart().getItems().add(item);
			return "Item added";
		}else{
			return "Invalid User ";
		}
	}
	
	@RequestMapping(value = "/Item/all", method = RequestMethod.GET)
	@ResponseBody
	public StringBuilder showProducts(){
		return this.controlMarket.showItems();
	}
	
	@RequestMapping(value = "/Item/{nameItem}", method = RequestMethod.GET)
	@ResponseBody
	public String getItem(@PathVariable String nameItem){
		Item item = this.controlMarket.getItemByName(nameItem);
		if(item.equals(null)) return "There is no product";
		else return item.toString();
	}
	

	@RequestMapping(value = "/User/Buy", method = RequestMethod.POST)
	@ResponseBody
	public String saveCart( @RequestBody UserBuy userBuy ){
		User user = this.map.getUserBy(userBuy.getIdUser());
		PayMode paymode = this.map.getPayMode(userBuy.getIdPaymode());
		Transaction tran = this.controlMarket.createTransaction(user,paymode);
		return "Total price is "+tran.getFinalPrice();
	}
	
	
	@RequestMapping(value="/Transaction/All", method = RequestMethod.GET)
	@ResponseBody
	public List<Transaction> getTransactions(){
		return this.controlMarket.getTransactions();
	}
	
	@ResponseBody
	@RequestMapping(value = "/User/ShoppingCart/{idUser}", method = RequestMethod.GET)
	public List<Item> getShoppingCarBy(@PathVariable int idUser){
		return this.map.getUserBy(idUser).getCart().getItems();
	}
}
