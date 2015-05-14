package com.dani.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;




import com.dani.main.GameOver;
import com.dani.main.Main;
import com.dani.main.Main.State;
import com.dani.main.Menu;

public class InputHandler implements KeyListener, MouseListener{

	boolean keys[] = new boolean[120];
	public boolean up, down, right , left;
	
	public void update(){
		up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true; 
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keys[e.getKeyCode()] = false;		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
			/*public static Rectangle Start = new Rectangle(100, 100, 200, 100);
	public static Rectangle About = new Rectangle(100, 250, 200, 100);*/
		
		int mx = e.getX();
		int my = e.getY();
		
		if(Main.state == State.Menu){
			if(Menu.Start.intersects(mx, my, 10, 10)){
				Main.state = State.Game;

			}
			if(Menu.About.intersects(mx, my, 10, 10)){
				Main.state = State.About;
			}
		}
		if(Main.state == State.GameOver){
			if(GameOver.Play.intersects(mx, my, 10, 10))
				Main.state = State.Game;
				
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		
	}
	
	

}
