
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class Main extends JFrame{
	
	static Bird b = new Bird(200, 550);
	
	static Thread bird = new Thread(b);
	
	Image dbImage;
	Graphics dbg;
	
	public Main(){
		setTitle("neger");
		setSize(600, 700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyHandler());
	}

	public static void main(String[] args) {
		Main main = new Main();
		
		bird.start();
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
		b.draw(g);
		
		repaint();
	}
	
	public class KeyHandler extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e){
			b.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e){
			b.keyReleased(e);
		}
	}
}
