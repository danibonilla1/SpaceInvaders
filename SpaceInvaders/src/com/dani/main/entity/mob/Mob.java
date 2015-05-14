package com.dani.main.entity.mob;

import java.awt.Rectangle;
import java.util.Random;

import com.dani.main.Sprite.Sprite;
import com.dani.main.entity.Entity;
import com.dani.main.gfx.Screen;

public abstract class Mob extends Entity{
	
	protected Sprite sprite;
	protected int dir = 2;
	protected boolean moving;
	protected static final Random random = new Random();
	protected Rectangle hitbox;
	protected boolean collide = false;
	
	public void render(Screen screen){
	}
	
	public void update(){
	}
	
	public void move(int xa, int ya){
		if(xa > 0) dir = 1;
		if(xa < 0) dir = 3;
		if(ya > 0) dir = 0;
		if(ya < 0) dir = 2;

		
		if(!collide){
			x+=xa;
			y+=ya;
		}
	}
	
	public boolean collision(Mob a, Mob b){
		if(a.hitbox.intersects(b.hitbox))
			collide = true;
		else
			collide = false;
		
		return collide;
	}

}
