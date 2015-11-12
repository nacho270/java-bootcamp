package com.Business;

public interface ObservedSubject {

	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers(String data);
	public void showMails();
}
