package com.dani.main.level;

import com.dani.main.Sprite.Sprite;

import com.dani.main.gfx.Screen;
import com.dani.main.level.tile.Tile;

public class Level {

	protected int width;
	protected int height;
	public int[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generate();

	}

	public Level(String path) {
		load(path);
	}

	public void generate() {

	}

	public void load(String path) {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + Sprite.voidSprite.SIZE) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + Sprite.voidSprite.SIZE) >> 4;

		for (int x = x0; x < x1; x++) {
			for (int y = y0; y < y1; y++) {
				getTile(x, y).render(x, y, screen);
			}
		}

	}

	public Tile getTile(int x, int y) {

		if (x < 0 || y < 0 || y > height || x > width)	return Tile.voidtile;
		if (tiles[x + y * width] == 0)	return Tile.voidtile;
		if (tiles[x + y * width] == 1)	return Tile.star;
		if (tiles[x + y * width] == 2)	return Tile.y_star;
		
		return Tile.voidtile;
	}
	

}
