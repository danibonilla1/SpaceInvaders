package com.dani.main.level.tile;

import com.dani.main.Sprite.Sprite;
import com.dani.main.gfx.Screen;

public class Asteroid extends Tile {

	public Asteroid(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
