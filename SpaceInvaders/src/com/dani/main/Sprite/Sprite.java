package com.dani.main.Sprite;

public class Sprite {

	public final int SIZE;
	public int x, y;
	public int[] pixels;
	public SpriteSheet sheet;

	public static Sprite rock = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite star1 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite star_y = new Sprite(16, 3, 0, SpriteSheet.tiles);

	public static Sprite ship_back = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite ship_back_1 = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite ship_back_2 = new Sprite(16, 0, 3, SpriteSheet.tiles);
	
	public static Sprite ship_right = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite ship_right_1 = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite ship_right_2 = new Sprite(16, 1, 3, SpriteSheet.tiles);
	
	public static Sprite ship_forward = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite ship_forward_1 = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite ship_forward_2 = new Sprite(16, 2, 3, SpriteSheet.tiles);

	public static Sprite ship_left = new Sprite(16, 3, 1, SpriteSheet.tiles);
	public static Sprite ship_left_1 = new Sprite(16, 3, 2, SpriteSheet.tiles);
	public static Sprite ship_left_2 = new Sprite(16, 3, 3, SpriteSheet.tiles);


	public Sprite(int size, int x, int y, SpriteSheet sheet) {

		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		setColor(color);
	}

	private void setColor(int color) {
		pixels = new int[SIZE * SIZE];
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}

	}

	public void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x * SIZE) + (y + this.y * SIZE)
						* sheet.SIZE];
			}
		}

	}
}
