package com.dani.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public static Rectangle Start = new Rectangle(100, 100, 200, 100);
	public static Rectangle About = new Rectangle(100, 250, 200, 100);

	public static void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		Font font = new Font("arial", Font.BOLD, 50);
		g2d.draw(Start);
		g2d.draw(About);
		g.setFont(font);
		g.drawString("Start", 140, 170);
		g.drawString("About", 120, 320);
	}

}
