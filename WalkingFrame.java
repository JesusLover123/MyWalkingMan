import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private ArrayList<Ball> balls;
	private Ball baller;
	
	public WalkingFrame()
	{
		setBounds(100,100,600,400);
		balls = new ArrayList<Ball>();
		man = new Man(0, 0);
		setLayout(null);
		add(man);
		Timer timer = new Timer(1, this);
		timer.start();
		addKeyListener(new KeyListener()
			{

				@Override
				public void keyPressed(KeyEvent e) 
				{
					if(e.getKeyCode() == e.VK_W)
					{
						man.setDY(-2);
					}
					if(e.getKeyCode() == e.VK_A)
					{
						man.setDX(-2);
					}
					if(e.getKeyCode() == e.VK_S)
					{
						man.setDY(2);
					}
					if(e.getKeyCode() == e.VK_D)
					{
						man.setDX(2);
					}
					if(e.getKeyCode() == e.VK_R)
					{
						baller = new Ball(man.getX() + 1, man.getY() + 1);
						baller.setDX(2);
						baller.setDY(0);
						balls.add(baller);
						add(baller);
					}
				}

				@Override
				public void keyReleased(KeyEvent e) 
				{
					if(e.getKeyCode() == e.VK_W)
					{
						man.setDY(0);
					}
					if(e.getKeyCode() == e.VK_A)
					{
						man.setDX(0);
					}
					if(e.getKeyCode() == e.VK_S)
					{
						man.setDY(0);
					}
					if(e.getKeyCode() == e.VK_D)
					{
						man.setDX(0);
					}
				}
		
				@Override
				public void keyTyped(KeyEvent e) 
				{
					
				}
				
			});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[]  args)
	{
		new WalkingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		man.update();
		for(int i = 0; i < balls.size(); i++)
		{
			balls.get(i).update();
		}
		repaint();
	}
}
