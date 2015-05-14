package com.dani.main.entity.mob;

import java.awt.Rectangle;

import com.dani.main.Sprite.Sprite;
import com.dani.main.gfx.Screen;

public class Rock extends Mob {
	private int speedy = random.nextInt(4) + 1;

	public Rock(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = Sprite.rock;
		hitbox = new Rectangle(this.x, this.y, sprite.SIZE, sprite.SIZE);
	}

	public void update() {
		y += speedy;
		hitbox.y = this.y;
	}

	public void render(Screen screen) {
		screen.renderObj(this.x, this.y, sprite);
	}

}
