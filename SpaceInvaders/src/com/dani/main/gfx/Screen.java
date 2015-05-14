package com.dani.main.gfx;

import com.dani.main.Sprite.Sprite;
import com.dani.main.level.tile.Tile;

public class Screen {
	public int[] pixels;
	public int width;
	public int height;

	public int xOffset, yOffset;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (ya < 0 || ya >= height || xa < -tile.sprite.SIZE || xa >= width) break;
				if (xa < 0) xa = 0;
				
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}

		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite){
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = x + xp;
				if(ya < 0 || xa < -sprite.SIZE || ya > height || xa > width) break;
				if(xa < 0) x = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if(col !=  0xff00ff00)
				pixels[xa + ya * width] = col;
				
			}
		}
	}

	public void renderObj(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < sprite.SIZE; y++){
			int ya = y + yp;
			for(int x = 0; x < sprite.SIZE; x++){
				int xa = x + xp;
				if(ya < 0 || xa < 0 || ya > height-1 || xa > width-1) break;
				if(xa < 0) x = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if(col !=  0xff00ff00)
				pixels[xa + ya * width] = col;
				
			}
		}		
	}
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}


}
