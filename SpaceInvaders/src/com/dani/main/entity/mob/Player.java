package com.dani.main.entity.mob;

import java.awt.Rectangle;

import com.dani.main.Sprite.Sprite;
import com.dani.main.gfx.Screen;
import com.dani.main.input.InputHandler;

public class Player extends Mob {

	private InputHandler input;
	private int anim = 0;
	private boolean moving = false;
	private int velocity = 4;

	public Player(InputHandler input) {
		this.input = input;
		sprite = Sprite.ship_back;
		hitbox = new Rectangle(this.x, this.y, sprite.SIZE, sprite.SIZE);
	}

	public Player(int x, int y, InputHandler input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.ship_back;
		hitbox = new Rectangle(this.x, this.y, sprite.SIZE, sprite.SIZE);
	}

	public void update() {
		int xa = 0;
		int ya = 0;

		if (anim > 7500)
			anim = 0;
		else
			anim++;

		if (input.up)
			ya-=(velocity);
		if (input.down)
			ya+=velocity;
		if (input.right)
			xa+=velocity;
		if (input.left)
			xa-=velocity;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;

		} else {
			moving = false;
		}
		
		hitbox.setLocation(x, y);

	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.ship_forward;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.ship_forward_1;
				} else {
					sprite = Sprite.ship_forward_2;
				}
			}

		}

		if (dir == 1) {
			sprite = Sprite.ship_right;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.ship_right_1;
				} else {
					sprite = Sprite.ship_right_2;
				}
			}

		}

		if (dir == 2) {
			sprite = Sprite.ship_back;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.ship_back_1;
				} else {
					sprite = Sprite.ship_back_2;
				}
			}
		}

		if (dir == 3) {
			sprite = Sprite.ship_left;
			if (moving) {
				if (anim % 20 > 10) {
					sprite = Sprite.ship_left_1;
				} else {
					sprite = Sprite.ship_left_2;
				}
			}
		}
		screen.renderPlayer(this.x, this.y, sprite);

	}

}
