package me.partick.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Player {

	// Fields
	public int charX;
	public int charY;
	public int charW = 25;
	public int charH = 25;
	public int xdirec;
	public int ydirec;
	

		ImageIcon image = new ImageIcon(getClass().getResource("/Character.png"));
		Image img = image.getImage();

	// Constructor
	public Player(int charXdir, int charYdir) {

		charX = charXdir;
		charY = charYdir;
	}

	// Method for drawing Player 1
	public void drawPlayer1(Graphics g) {

		g.setColor(Color.BLUE);
		g.drawImage(img, charX, charY, (ImageObserver)this);
	}

	// Get X direction
	public void setXDirection(int xdir) {

		xdirec = xdir;
	}

	// Get Y direction
	public void setYDirection(int ydir) {

		ydirec = ydir;
	}

	// Move method for Player 1
	public void move() {

		charX += xdirec;
		charY += ydirec;

		if (charX <= 0) {

			charX = 0;
		}
		if (charX >= 625) {

			charX = 625;
		}
		if (charY <= 22) {

			charY = 22;
		}
		if (charY >= 475) {

			charY = 475;
		}
	}
}
