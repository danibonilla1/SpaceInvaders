package com.dani.main.entity;

import com.dani.main.level.Level;

public abstract class Entity {
	public int x, y;
	protected boolean removed;
	protected Level level;
	
	
	public void update(){
	}
	
	public boolean isRemoved(){
		return removed;
	}
	
	public void remove(){
		removed = true;
	}

}
