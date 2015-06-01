package me.partick.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Sanik extends JFrame implements Runnable {
	// I don't know what this does
	private static final long serialVersionUID = 3743084572020436043L;
	//////////////////////////////
	
	//Ghetto Game States
	static boolean mainMenu = true;
	static boolean levelOne = false;
	static boolean levelTwo = false;
	static boolean Quit = false;
	
	/////////////////////
	Image dbi;
	Graphics dbg;

	public Sanik() {
		setTitle("Sanik Speyd Advantur");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		addKeyListener(new KB());
	}

	public void paint(Graphics g) {
		dbi = createImage(getWidth(), getHeight());
		dbg = dbi.getGraphics();
		paintComp(dbg);
		g.drawImage(dbi, 0, 0, this);

	}

	public void paintComp(Graphics g) {
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		// Char
		g.setColor(Color.cyan);
		repaint();

	}

	public static void main(String[] args) {
		Sanik sanik = new Sanik();
		Thread t1 = new Thread(sanik);
		t1.start();

	}

	public class KB extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();

			if (k == e.VK_UP) {
				
			}
			if (k == e.VK_DOWN) {
				
			}
			if (k == e.VK_RIGHT) {
				
			}
			if (k == e.VK_LEFT) {
				
			}
		}

		public void keyReleased(KeyEvent e) {
			int k = e.getKeyCode();

			if (k == e.VK_UP) {
				
			}
			if (k == e.VK_DOWN) {
				
			}
			if (k == e.VK_RIGHT) {
				
			}
			if (k == e.VK_LEFT) {
				
			}

		}

	}

	public void run() {

		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
