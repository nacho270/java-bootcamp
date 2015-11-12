package com.Services;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.Business.Cash;
import com.Business.CreditCard;
import com.Business.PayMode;
import com.Business.Paypal;
import com.Business.User;

@Component
public class Mapper {
	
	private static int idUser = 0;
	private Map<Integer, User> userMap;
	
	public Mapper(){
	}
	
	@PostConstruct
	public void init(){
		this.userMap= new HashMap<Integer, User>();
	} 
	
	public int addUser(User user){
		idUser++;
		this.userMap.put(idUser, user);
		return idUser;
	}
	
	public User getUserBy(int id){
		return this.userMap.get(id);
	}
	
	/* 1 - cash
	 * 2- CreditCard
	 * 3- paypal
	 * */
	public PayMode getPayMode(int id){
		if( 1 == id){
			return new Cash();}
		if( 2 == id){
			return new CreditCard();}
		if( 3 == id){
			return new Paypal();}
		return null;
	}
	
	public boolean existsUser(int idUser){
		return this.userMap.containsKey(idUser);
	}
	
	
}
