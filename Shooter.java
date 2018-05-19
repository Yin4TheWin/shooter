//Franklin Yin


//Imports
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

public class Shooter extends Application implements EventHandler<InputEvent>
{
	AnimateObjects animate=new AnimateObjects();
	//Check the player and enemy classes for information on methods each class has. tl;dr they are getter and setter methods
	Player player=new Player(new Image("player.png"));
	ArrayList <Enemy> list=new ArrayList<>();
	int enemyMove=0;
	int enemySpeed=1;
	int playerX=0;
	int spawnRange=3;
	int spawnStart=2;
	boolean hitLeft=false;
	boolean hitRight=false;
	Canvas canvas=new Canvas(500,400);
	GraphicsContext gc=canvas.getGraphicsContext2D();
	public static void main(String[] args)
	{
		launch();
	}
	public void start(Stage stage)
	{
		stage.setTitle("Shooter");
		Group root=new Group();
		root.getChildren().add(canvas);
		Scene scene=new Scene(root);
		stage.setScene(scene);
		spawnEnemy();
		animate.start();
		stage.show();
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
	}
	public void handle(final InputEvent event)
	{
		if(hitLeft)
			hitLeft=false;
		else if(!hitLeft&&((KeyEvent)event).getCode()==KeyCode.LEFT)
			playerX-=10;
		if(hitRight)
			hitRight=false;
		else if(!hitRight&&((KeyEvent)event).getCode()==KeyCode.RIGHT)
			playerX+=10;
		if(((KeyEvent)event).getCode()==KeyCode.UP)
		{
			URL resource=getClass().getResource("hitting.wav");
			AudioClip clip=new AudioClip(resource.toString());
			clip.play();
			spawnEnemy();
		}
	}
	public void spawnEnemy()
	{
		for(int i=0;i<(int)(Math.random()*spawnRange)+spawnStart;i++)
			list.add(new Enemy(new Image("enemy.png"), (int)(Math.random()*750)+1, 0));
	}
	public class AnimateObjects extends AnimationTimer
	{
		public void handle(long now)
		{
			enemyMove+=enemySpeed;
			gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
			gc.drawImage(player.getImage(),player.getXPos()+playerX,350);
			if(player.getXPos()+playerX>=450)
				hitRight=true;
			if(player.getXPos()+playerX<=0)
				hitLeft=true;
			for (int i=0;i<list.size();i++){
				gc.drawImage(list.get(i).getImage(),list.get(i).getXPos(),list.get(i).getYPos()+enemyMove);
				if(enemyMove>=350)
				{
					URL resource=getClass().getResource("hit.wav");
					AudioClip clip=new AudioClip(resource.toString());
					clip.play();
					list.remove(i);
				}
			}
		}
	}
}
