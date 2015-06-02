package me.partick.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Sanik extends JFrame implements Runnable {
	// I don't know what this does
	private static final long serialVersionUID = 3743084572020436043L;
	///////////////////////////////

	private int choice = 0;

	//Not So Ghetto Game States
	public String[] gameState = { "Play", "Level Select", "Quit" };
	
	///////////////////////////////
	Image dbi;
	Graphics dbg;

	private boolean isSelecting = false;
	
	public Sanik() {
		setTitle("Sanik Speyd Advantur");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		addKeyListener(new KB());
		setAlwaysOnTop(true);
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

		for (int i = 0; i < gameState.length; i++) {

			if (i == choice) {

				g.setColor(Color.CYAN);
			} else {

				g.setColor(Color.RED);
			}
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
			g.drawString("- " + gameState[i], 220, 440 + i * 48);
		}

		// /////////////////////////////////////
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
			selected();

			if (k == e.VK_UP) {
				choice--;
				if(choice == -1){
					
					choice = gameState.length - 1;
				}
			}
			if (k == e.VK_DOWN) {
				choice ++;
				if(choice == gameState.length){
					
					choice = 0;
				}
			}
			if (k == e.VK_RIGHT) {

			}
			if (k == e.VK_LEFT) {

			}
			if(k == e.VK_ENTER){
				isSelecting = true;
				
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
			if(k == e.VK_ENTER){
				isSelecting = true;
			}

		}
		private void selected(){
			if(choice == 0 && isSelecting){
				
				
			}
			
			if(choice == 1 && isSelecting){
				
				
			}
			
			if(choice == 2 && isSelecting){
				
				System.exit(0);
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
