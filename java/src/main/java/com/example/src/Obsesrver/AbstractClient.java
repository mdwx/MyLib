package com.example.src.Obsesrver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class AbstractClient extends Observable implements Observer{
	List<Observable> observableList;	
	public AbstractClient() {		
		observableList = new ArrayList<Observable>();
	}
	public AbstractClient(Observable observable) {
		this.observableList.add(observable);		
		observable.addObserver((Observer) this);		
	}

	public void Subscribe(Observable observable) {
		for(Observable servers : observableList){
			if(servers == observable){
				servers.addObserver((Observer) this);
				return;
			}
		}
		this.observableList.add(observable);		
		observable.addObserver((Observer) this);		
	}
	public void Unsubscribe(Observable observable) {	
		for(Observable servers : observableList){
			if(servers == observable){
				servers.deleteObserver((Observer) this);
				observableList.remove(servers);
				return;
			}
		}
		observable.deleteObserver((Observer) this);		
	}
	public void unsubscribeAll() {
		for(Observable servers : observableList){
			servers.deleteObserver((Observer) this);
		}		
		observableList.clear();
	}
	public List<Observable> getSubscribeList() {
		return observableList;
	}
	public void setSubscribeList(List<Observable> observableList) {
		this.observableList = observableList;
		for(Observable servers : observableList){		
				servers.addObserver((Observer) this);
		}
		
	}	
}
