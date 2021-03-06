package me.partick.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Sanik extends JFrame implements Runnable {
	// I don't know what this does
	private static final long serialVersionUID = 3743084572020436043L;

	// Level Selection/Options
	private int choice = 0;
	public String[] gameState = { "Play", "Level Select", "Quit" };
	//Main Menu
	ImageIcon main = new ImageIcon(getClass().getResource("/mainMenu.png"));
	Image Menu = main.getImage();
	
	Image dbi;
	Graphics dbg;

	private boolean isSelecting = false;
	public boolean levelOne = false;
	private boolean gameStarted = false;
	
	// Objects
	Player p = new Player(368, 268);
	LevelOne LO = new LevelOne();

	// Methods
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
		//Main Menu
		g.drawImage(Menu, 225, 100, this);
		for (int i = 0; i < gameState.length; i++) {

			if (i == choice) {

				g.setColor(Color.CYAN);
			} else {

				g.setColor(Color.RED);
			}
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 48));
			g.drawString("- " + gameState[i], 220, 440 + i * 48);
		}
		if (levelOne) {
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, 800, 600);
			// Creating the player
			p.drawPlayer1(g);
			
			//g.drawImage(img, charX, charY, this);

		}
		// temp
		if (levelOne == true) {
			gameStarted = true;
			isSelecting = false;
		}

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

			if (k == KeyEvent.VK_UP && gameStarted == false) {
				choice--;
				if (choice == -1) {

					choice = gameState.length - 1;
				}
			}
			if (k == KeyEvent.VK_DOWN && gameStarted == false) {
				choice++;
				if (choice == gameState.length) {

					choice = 0;
				}
				//Main Menu Selection
			}
			if (k == KeyEvent.VK_RIGHT && gameStarted == false) {

			}
			if (k == KeyEvent.VK_LEFT && gameStarted == false) {

			}
			if (k == KeyEvent.VK_ENTER && gameStarted == false) {
				isSelecting = true;

			}
			//Character Movement
			if (k == KeyEvent.VK_UP && gameStarted == true) {
				p.setYDirection(-6);

			}
			if (k == KeyEvent.VK_DOWN && gameStarted == true) {
				p.setYDirection(+6);

			}
			if (k == KeyEvent.VK_LEFT && gameStarted == true) {
				p.setXDirection(-6);
			}
			if (k == KeyEvent.VK_RIGHT && gameStarted == true) {
				p.setXDirection(+6);

			}
		}

		public void keyReleased(KeyEvent e) {
			int k = e.getKeyCode();

			if (k == KeyEvent.VK_UP) {

			}
			if (k == KeyEvent.VK_DOWN) {

			}
			if (k == KeyEvent.VK_RIGHT) {

			}
			if (k == KeyEvent.VK_LEFT) {

			}
			if (k == KeyEvent.VK_ENTER) {

			}

		}

		private void selected() {
			if (choice == 0 && isSelecting) {
				levelOne = true;
			}

			if (choice == 1 && isSelecting) {

			}

			if (choice == 2 && isSelecting) {

				System.exit(0);
			}

		}

	}

	public void run() {
		try {
			while(true){
				
				p.move();
			Thread.sleep(15);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
