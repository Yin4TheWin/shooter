import javafx.scene.image.*;
public class Player
{
	private Image image;
	private int xPos=250;
	private int yPos=250;
	public Player(Image image)
	{
		this.image=image;
	}
	public Image getImage()
	{
		return image;
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