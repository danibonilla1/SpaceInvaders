package com.dani.main.Sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/textures/Sprites.png", 256);
	public static SpriteSheet me = new SpriteSheet("/textures/thinker.jpg", 4128);
	
	
	public SpriteSheet(String path, int size){
		SIZE = size;
		this.path = path;
		pixels = new int[SIZE*SIZE];
		load();
		
	}
	
	public void load(){
		BufferedImage image;
		try {
			image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
