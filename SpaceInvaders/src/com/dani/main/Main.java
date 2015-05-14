package com.dani.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.dani.main.entity.mob.Player;
import com.dani.main.gfx.Screen;
import com.dani.main.input.InputHandler;
import com.dani.main.level.RandomLevel;

public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static int width = 400;
	public static int height = 400;
	public static double Delta = 0;

	private boolean running = false;
	private Thread thread;
	private JFrame frame;
	private InputHandler k;
	public static RandomLevel LevCrazy;
	private Player player;
	public static String points;

	private Screen screen;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	int xScroll;
	int yScroll;
	public static Menu menu;
	
	public enum State{
		Menu,
		Game,
		GameOver,
		About
	};
	
	public static State state = State.Menu;

	public Main() {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		frame = new JFrame();
		k = new InputHandler();
		screen = new Screen(width, height);
		LevCrazy = new RandomLevel(1000, 1000);
		player = new Player(700 / 2 << 4, 700 / 2 << 4, k);

		addKeyListener(k);
		addMouseListener(k);
	}

	public void start() {
		running = true;
		Thread thread = new Thread(this, "game");
		thread.start();

	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double delta = 0D;
		double ns = 1000000000D / 60D;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			Delta = delta;
			lastTime = now;
			if (delta > 1D) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ups " + updates + " || Frames " + frames);
				updates = 0;
				frames = 0;
			}

		}

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		xScroll = player.x - screen.width / 2;
		yScroll = player.y - screen.height / 2;
		screen.clear();
		
		if(state == State.Game){
			LevCrazy.render(xScroll, yScroll, screen);
			player.render(screen);
		}

		for (int i = 0; i < pixels.length; i++) {
			this.pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if(state == State.Menu){
			Menu.render(g);
		}
		if(state == State.GameOver){
			GameOver.render(g);
		}
		if(state == State.About){
			About.render(g);
		}
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Points : " + LevCrazy.getCount(), 10, 20);
		g.drawString("Life : " + LevCrazy.getLife(), width - 80, 20);
		g.dispose();
		bs.show();

	}

	private void update() {
		k.update();
		if(state == State.Game){
			player.update();
			LevCrazy.update(xScroll, yScroll, player);
			
			if(LevCrazy.life <= 0){
				points = LevCrazy.getCount();
				state = State.GameOver;
				reset();
			}
		}

	}

	private void reset() {
		LevCrazy = new RandomLevel(700, 700);
		player = new Player(700 / 2 << 4, 700 / 2 << 4, k);
		
	}

	public static void main(String[] args) {
		Main game = new Main();

		game.frame.setResizable(false);
		game.frame.setTitle("SpaceShip");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setLocationRelativeTo(null);
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);

		game.start();

	}

}