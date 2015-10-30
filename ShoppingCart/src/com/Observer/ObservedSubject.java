package com.Observer;

public interface ObservedSubject {

	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers(String data);
	public void showMails();
}
