import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.JComponent;


public class Ball extends JComponent
{
	private int dx, dy = 0;
	
	public Ball(int x, int y)
	{
		setLocation(x,y);
		setSize(20,40);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.RED);
		Ellipse2D.Double bullet = new Ellipse2D.Double(0, 0, 10, 10);
		g2.fill(bullet);
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
}
