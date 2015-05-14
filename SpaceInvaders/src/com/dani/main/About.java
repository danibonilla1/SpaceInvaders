package com.dani.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class About {
	public static Rectangle Back = new Rectangle(120, 100, 200, 100);
	
	public static void render(Graphics g){
		 g.setColor(Color.CYAN);
		g.drawString("This game has been made just for practice purposes in Java.", 10, 40);
		g.drawString(" This is the second game that I've ever created.", 10, 60);
		g.drawString("I would really apreciate any suggestions of improvement about ", 10, 80);
		g.drawString("my code and the game as it is. Thanks!", 10, 100);
	}

}
