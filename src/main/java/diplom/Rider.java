package diplom;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Rider implements Runnable {

	
	private ImageView imageView;
	private Button[] btn;
	private ImageView iv;
	private Semaphore sem;
	private boolean horseChoose =false;
	private String name;
	Rider(){}

	public Rider(String name, ImageView imageView, Button[] btn, Semaphore sem) 
	{
		this.name = name;
		this.imageView = imageView;
		this.btn = btn;
		this.sem = sem;
		new Thread(this).start();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageView getHorse() 
	{	
		return iv;	
	}
	public boolean isHorseChoose() 
	{
		return horseChoose;
	}
	@Override
	public void run() {
		try {
			
			sem.acquire();
			for(int i = 0; i < btn.length;i++) 
			{
				if(!btn[i].isDisabled()) 
				{
					iv = (ImageView) btn[i].getGraphic();
					btn[i].setDisable(true);
					horseChoose = true;
					break;
				}
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		sem.release();

	}
		
	}


