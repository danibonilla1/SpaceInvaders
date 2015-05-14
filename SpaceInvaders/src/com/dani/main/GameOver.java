package com.dani.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameOver {
	public static Rectangle Play = new Rectangle(100, 100, 200, 100);
	
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Game Over", 80, 70);
		g.setFont(new Font("arial", Font.BOLD, 30));
		g.drawString("Play Again", 120, 150);
		g2d.draw(Play);
		g.drawString("Score: " + Main.points, 120, 250);
	}
}
