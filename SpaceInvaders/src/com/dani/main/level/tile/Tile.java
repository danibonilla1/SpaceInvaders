package com.dani.main.level.tile;

import com.dani.main.Sprite.Sprite;
import com.dani.main.gfx.Screen;


public class Tile {
	protected int x, y;
	public Sprite sprite;
	
	public static Tile asteroid = new Asteroid(Sprite.rock);
	public static Tile voidtile = new VoidTile(Sprite.voidSprite);
	public static Tile star = new VoidTile(Sprite.star1);
	public static Tile y_star = new VoidTile(Sprite.star_y);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	public void generate(){
		
	}
	
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
}

