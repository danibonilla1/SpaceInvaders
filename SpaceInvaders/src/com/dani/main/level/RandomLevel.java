package com.dani.main.level;

import java.util.ArrayList;
import java.util.Random;

import com.dani.main.Main;
import com.dani.main.Sprite.Sprite;
import com.dani.main.entity.mob.Player;
import com.dani.main.entity.mob.Rock;
import com.dani.main.gfx.Screen;

public class RandomLevel extends Level {

	private int difficulty = 20;
	private double Counter = 0;
	public static final Random random = new Random();
	private ArrayList<Rock> asteroid = new ArrayList<Rock>();
	public int count = 0;
	public int life = 50;

	public RandomLevel(int width, int height) {
		super(width, height);
	}

	public void generate() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x + y * width] = random.nextInt(4);
			}
		}
	}

	public void update(int xScroll, int yScroll, Player player) {
		Counter += Main.Delta;
		if (Counter > difficulty) {
			Counter = 0;
			asteroid.add(new Rock(xScroll + random.nextInt(Main.width) , yScroll));
		}
		for(Rock r : asteroid){
			if( r.y > Main.height + yScroll + Sprite.rock.SIZE){
				if(r.y > Main.height + yScroll + Sprite.rock.SIZE) life--;
				asteroid.remove(r);
				break;
			}
			if(r.collision(player, r)){
				asteroid.remove(r);
				count++;
				break;
			}
				r.update();
		}
		
		//Check collision
		
		if(count%10 == 0 && count != 0){
			difficulty--;
			count++;
		}
		
		
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
		
		for(Rock r: asteroid){
			if(r.x < xScroll-Sprite.rock.SIZE || r.x > screen.width + xScroll || r.y < yScroll || r.y > screen.height + yScroll) continue;
			else r.render(screen);
		}

	}
	
	public String getCount(){
		return "" + count;
	}

	public String getLife() {
		return "" + life;
	}
	

}
