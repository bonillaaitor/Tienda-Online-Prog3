package Tienda;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.border.Border;

public class Fondo implements  Border{

	public Fondo(BufferedImage read) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Insets getBorderInsets(Component c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

}
