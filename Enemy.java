//Franklin Yin
import javafx.scene.image.*;
public class Enemy
{
	private Image image;
	private int xPos;
	private int yPos;
	public Enemy(Image image, int xPos, int yPos)
	{
		this.image=image;
		this.xPos=xPos;
		this.yPos=yPos;
	}
	public Image getImage()
	{
		return image;
	}
	public void setImage(Image image)
	{
		this.image=image;
	}
	public void setXPos(int xPos)
	{
		this.xPos=xPos;
	}
	public void setYPos(int yPos)
	{
		this.yPos=yPos;
	}
	public int getXPos()
	{
		return xPos;
	}
	public int getYPos()
	{
		return yPos;
	}
}