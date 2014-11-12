import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;


public class Bird implements Runnable{
	
	int x, y, xDirection, yDirection, b1y = 0, b2y = -700;
	
	Image bird = ResourceLoader.getImage("Bird_Gun.gif");
	Image islands = ResourceLoader.getImage("Islands_Back.png");
	
	public Bird(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == e.VK_UP){
			setYDirection(-1);
		}
		if(e.getKeyCode() == e.VK_DOWN){
			setYDirection(1);
		}
		if(e.getKeyCode() == e.VK_LEFT){
			setXDirection(-1);
		}
		if(e.getKeyCode() == e.VK_RIGHT){
			setXDirection(1);
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == e.VK_UP){
			setYDirection(0);
		}
		if(e.getKeyCode() == e.VK_DOWN){
			setYDirection(0);
		}
		if(e.getKeyCode() == e.VK_LEFT){
			setXDirection(0);
		}
		if(e.getKeyCode() == e.VK_RIGHT){
			setXDirection(0);
		}
	}
	
	public void setXDirection(int dir){
		xDirection = dir;
	}
	public void setYDirection(int dir){
		yDirection = dir;
	}
	
	public void move(){
		x += xDirection;
		y += yDirection;
		if(x < -20){
			x=-20;
		}
		if(x > 520){
			x=520;
		}
		if(y < 20){
			y=20;
		}
		if(y > 640){
			y=640;
		}
		if(b1y > 700){
			b1y = -698;
		}
		if(b2y > 700){
			b2y = -698;
		}
		b1y++;
		b2y++;
	}
	
	public void draw(Graphics g){
		g.drawImage(islands, 0, b1y, null);
		g.drawImage(islands, 0, b2y, null);
		g.drawImage(bird, x, y, null);
	}

	@Override
	public void run() {
		try{
			while(true){
				move();
				Thread.sleep(4);
			}
		}
		catch(Exception e){
			
		}
	}
}
