package diplom;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class App extends Application
{
	private Stage primaryStage;
	private Screen screen = Screen.getPrimary();
	private Rectangle2D bounds = screen.getVisualBounds();
	private boolean isSound = false;
	private String name;
	private ImageView character;
	private ImageView myHorse;
	private ImageView enemy1 = new ImageView("/Andy.png");
	private ImageView enemy2 =  new ImageView("/Буч.png");
	private ImageView enemy3 = new ImageView("/клаудий.png");
	private ImageView enemy4 = new ImageView("/виктор.png");
	private Label enemyName;
	private Rider rider1;
	private Rider rider2;
	private Rider rider3;
	private Rider rider4;
	private TextField tf;
	private int money = 1000;
	private int myRate = 0;
	private int enemyRate = 0;
	private ImageView oponent;
	private Media m;	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		 m = new Media(getClass().getResource("/la-bouche-be-my-lover.mp3").toString());	
		 new MediaPlayer(m).play();	
		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		GridPane root = new GridPane();
		root.setId("root1");
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Label label = new Label("Enter your name");
		label.setId("label1");
		Button button = new Button("OK");
		Button button2 = new Button("EXIT");
		TextField text = new TextField();
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		root.setAlignment(Pos.CENTER);
		root.add(label, 0, 0);
		root.add(text, 1, 0);
		root.add(button,1 , 2);
		root.add(button2, 1, 3 );
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		this.primaryStage.setMaximized(true);
		primaryStage.show();
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(text.getText() != null) 
				{
					name = text.getText();
					primaryStage.setScene(getPlatformOfChoosingCharactor());
				}
				
			}});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Platform.exit();
				
			}});
	} 
	
	
	
	
	public Scene getPlatformOfChoosingCharactor() 
	{
		GridPane root = new GridPane();
		root.setId("faceRoot");
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Label label = new Label("Hello " + name + " Choose your Character");
		label.setId("faceLabel");
		ImageView iv1 = new ImageView("/лиза.png");
		ImageView iv2 = new ImageView("/Марти.png");
		ImageView iv3 = new ImageView("/денис.png");
		Button button1 = new Button();
		Button button2 = new Button();
		Button button3 = new Button();
		button1.setGraphic(iv1);
		button2.setGraphic(iv2);
		button3.setGraphic(iv3);
		
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		root.add(label, 1, 0);
		root.add(button1, 0, 2);
		root.add(button2, 1, 2);
		root.add(button3, 2, 2);
		
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				character = iv1;
				primaryStage.setScene(rateStage());
				
			}});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				character = iv2;
				primaryStage.setScene(rateStage());
				
			}});
		button3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				character = iv3;
				primaryStage.setScene(rateStage());
				
			}});
		return scene;
	}
	public Scene rateStage()
	{
		
		Label moneyLabel = new Label(Integer.toString(money) + "$");
		GridPane root = new GridPane();
		root.setId("faceRoot");
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25,25,25,25));
		Label label = new Label("Your character");
		Label labelCash = new Label("Your cash");
		Label rate = new Label("Make your rate and start the race");
		Button button = new Button("Start");
		label.setId("roundLabel");
		labelCash.setId("roundLabel");
		moneyLabel.setId("roundLabel");
		rate.setId("roundLabel");
		ImageView character1 = character;
		ImageView horse = myHorse;
		tf = new TextField();
		root.add(label, 0, 0);
		root.add(character, 0, 1);
		root.add(labelCash, 0, 2);
		root.add(moneyLabel, 1, 2);
		root.add(rate, 0, 3);
		root.add(tf, 3, 3);
		root.add(button, 3, 4);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				if(tf.getText().contains("0") || tf.getText().contains("1") || tf.getText().contains("2") 
						|| tf.getText().contains("3") || tf.getText().contains("4") || tf.getText().contains("5") 
						|| tf.getText().contains("6") || tf.getText().contains("7") || tf.getText().contains("8") 
						|| tf.getText().contains("9")) 
				{
					myRate = Integer.parseInt(tf.getText());
					if(myRate <= money && myRate > 100) 
					{
						
						primaryStage.setScene(faceToFaceStage());
					}else
						tf.setText("Not enough money or Make your rate bigger");
				}
				else 
				{
					tf.setText("Enter numbers");
				}
		
			
		
				
			}});
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
		
	}
	public Scene faceToFaceStage() 
	{
		GridPane root = new GridPane();
		Random rnd = new Random();
		Label label2 = new Label();
		Button button = new Button("Next Stage");
		label2.setId("faceLabel");
		root.setId("faceRoot");
		root.setAlignment(Pos.CENTER);
		root.add(character,0,1);
		Label name1 = new Label("Andy");
		Label name2 = new Label("Buch");
		Label name3 = new Label("Claudiy");
		Label name4 = new Label("Viktor");
		int result = rnd.nextInt(4);
		System.out.println(result);
		enemyRate = rnd.nextInt(500)+100;
		enemyRate+=myRate/2;
		if(result == 1) 
		{
			oponent = enemy1;
			enemyName = name1;
			root.add(enemy1, 1, 1);
		}else
			if(result == 2) 
			{
				oponent = enemy2;
				enemyName = name2;
				root.add(enemy2, 1, 1);
			}else
				if(result == 3) 
				{
					oponent = enemy3;
					enemyName = name3;
					root.add(enemy3, 1, 1);
				}else 
				{
					oponent = enemy4;
					enemyName = name4;
					root.add(enemy4, 1, 1);
				}
		Label label = new Label("Rate: " + Integer.parseInt(tf.getText()) + "$");
		Label label1 = new Label("Rate: " + String.valueOf(enemyRate) + "$");
		label.setId("faceLabel");
		label1.setId("faceLabel");
		root.add(label, 0, 2);
		root.add(label1, 1, 2);
		root.add(label2, 1, 0);
		root.add(button, 1, 3);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(stageOfChoosingHorse());
				
			}});
		
		
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
	public Scene stageOfChoosingHorse() 
	{
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 400,400);
		Label label = new Label(name);
		Label label1 = enemyName;
		Label label5 = new Label("You need to choose your horse");
		label5.setId("faceLabel");
		Button button1 = new Button();
		button1.setGraphic(new ImageView("/unnamed.png"));
		Button button2 = new Button();
		button2.setGraphic(new ImageView("/unnamed1.png"));
		Button button3 = new Button();
		button3.setGraphic(new ImageView("/unnamed2.png"));
		Button button4 = new Button();
		button4.setGraphic(new ImageView("/unnamed3.png"));
		Button button5 = new Button();
		button5.setGraphic(new ImageView("/unnamed4.png"));
		label.setId("name");
		label1.setId("name");
		root.setId("faceRoot");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		root.setAlignment(Pos.TOP_CENTER);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		root.add(label5, 1, 0);
		root.add(character, 0, 1);
		root.add(label,0,2);
		root.add(button1, 0, 4);
		root.add(oponent, 4, 1);
		root.add(label1,5,2);
		root.add(button2, 1, 4);
		root.add(button3, 2, 4);
		root.add(button4, 3, 4);
		root.add(button5, 4, 4);
		Button[] btn = {button1,button2,button3,button4,button5};
		Random rnd = new Random();
		Semaphore sem = new Semaphore(1,true);
		for(int i = 0; i < btn.length;i++) 
		{
			int j = rnd.nextInt(btn.length);
			Button tmp = btn[i];
			btn[i] = btn[j];
			btn[j] = tmp;
		}
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button1.setDisable(true);
				myHorse = new ImageView("/unnamed.png");
				
					rider1 = new Rider(label1.getText(), enemy1, btn, sem);
					
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						do{
							
								System.out.println("HHH");
								if(rider1.isHorseChoose() == true) 
								{
									try {
										primaryStage.setScene(raceStage());
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								}
							
							
						}while(true);
						
					}});

			}});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button2.setDisable(true);
				myHorse = new ImageView("/unnamed1.png");
				
					rider1 = new Rider(label1.getText(), enemy1, btn, sem);
					
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						do{
							
								System.out.println("HHH");
								if(rider1.isHorseChoose() == true) 
								{
									try {
										primaryStage.setScene(raceStage());
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								}
							
							
						}while(true);
						
					}});

			}});
		button3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button3.setDisable(true);
				myHorse = new ImageView("/unnamed2.png");
				
					rider1 = new Rider(label1.getText(), enemy1, btn, sem);
					
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						do{
							
								System.out.println("HHH");
								if(rider1.isHorseChoose() == true) 
								{
									try {
										primaryStage.setScene(raceStage());
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								}
							
							
						}while(true);
						
					}});

			}});
		button4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button4.setDisable(true);
				myHorse = new ImageView("/unnamed3.png");
				
					rider1 = new Rider(label1.getText(), enemy1, btn, sem);
					
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						do{
							
								System.out.println("HHH");
								if(rider1.isHorseChoose() == true) 
								{
									try {
										primaryStage.setScene(raceStage());
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
									
								}
							
							
						}while(true);
						
					}});

			}});
		button5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				button5.setDisable(true);
				myHorse = new ImageView("/unnamed4.png");
				
					rider1 = new Rider(label1.getText(), enemy1, btn, sem);
					
				
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						do{
							
								System.out.println("HHH");
								if(rider1.isHorseChoose() == true) 
								{
									try {
										primaryStage.setScene(raceStage());
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									break;
									
								}
							
							
						}while(true);
						
					}});

			}});
		
		return scene;
	}
	
	private boolean flag;
	private int count;
	public void setTime(Label label)
	{
		
		do 
		{
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					flag = true;
						count--;
							if(count == 0 ) 
							{
								
								flag = false;
								label.setVisible(false);
							}
							label.setText(String.valueOf(count));
		
				}});
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(flag);
		
	}
	private int x=0;
	private int x1=0;
	private Random rnd = new Random();
	private Random rnd2 = new Random();
	volatile boolean finish = true;
	private boolean win1 = false;
	private boolean win2 = false;
	public void horseRun(ImageView iv) throws InterruptedException 
	{
		x = 0;
		win1 = false;
		while(count > 0) {System.out.println("");}
		do 
		{
			int speed = rnd.nextInt(100);
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					
					if(bounds.getWidth() > x) 
					{
							
							x+=5;
							iv.setTranslateX(x);	
							
					}else 
					{
						finish = false;
						primaryStage.setScene(winnerStage());
						win1 = true;
						
					}
					
				}});
			TimeUnit.MILLISECONDS.sleep(speed);
			System.out.println("Speed " + speed);
		}while(finish);
		
		finish = true;
	}
	
	public void horseRun2(ImageView iv) throws InterruptedException 
	{
		x1 = 0;
		win2 = false;
		while(count > 0) {System.out.println("");}
		do 
		{
			int speed = rnd.nextInt(100);
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					
					if(bounds.getWidth() > x1) 
					{
							
							x1+=5;
							iv.setTranslateX(x1);	
							
					}else 
					{
						finish = false;
						primaryStage.setScene(winnerStage());
						win2 = true;
						
					}
					
					
				}});
			TimeUnit.MILLISECONDS.sleep(speed);
			System.out.println("Speed " + speed);
		}while(finish);
		finish = true;
		
	}
	
	public Scene raceStage() throws InterruptedException 
	{
		GridPane root = new GridPane();
		root.setId("root3");
		count = new Integer(4);
		root.setAlignment(Pos.BOTTOM_LEFT);
		root.add(myHorse,0,5);
		root.add(rider1.getHorse(), 0, 0);
		
		Runnable task = new Runnable() {

			@Override
			public void run() {
				
				Label label = new Label("3");
				label.setId("timerLabel");
				root.add(label, 5, 10);
				setTime(label);
				
			}};
			Thread timer = new Thread(task);
			timer.start();
			Runnable task3 = new Runnable() {

				@Override
				public void run() {
					try {
						horseRun(rider1.getHorse());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}};
			
				
				Thread horse = new Thread(task3);
				horse.setDaemon(true);
				horse.start();
				
				Runnable hold = new Runnable() {

					@Override
					public void run() {
						
						try {
							horseRun2(myHorse);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}};
					Thread hold1 = new Thread(hold);
					hold1.setDaemon(true);
					hold1.start();
				
			
				
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		
		return scene;
	}
	
	
	public Scene winnerStage() 
	{
		GridPane root = new GridPane();
		root.setId("faceRoot");
		root.setAlignment(Pos.CENTER);
		Button repeat = new Button("New race");
		Button exit = new Button("Exit");
		Label label = new Label("The winner");
		label.setId("name");
		Label label2;
		root.add(label, 0, 0);
		root.add(repeat,0 ,4 );
		root.add(exit, 1, 4);
		
		if(win2  == true && win1 != true) 
		{
			root.add(character, 0, 1);
			root.add(myHorse, 0, 2);
			money+=enemyRate;
			label2 = new Label("Cash: " + money + "$");
			label2.setId("roundLabel");
			root.add(label2,0,3);
		}else
			if(win1 == true && win2 != true) 
			{
				
				root.add(oponent, 0, 1);
				root.add(rider1.getHorse(), 0, 2);
				money-=myRate;
				label2 = new Label("Your Cash: " + money + "$");
				label2.setId("roundLabel");
				root.add(label2,0,3);
			}
		
		repeat.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				if(money <=100) 
				{
					primaryStage.setScene(loseStage());
				}else
				primaryStage.setScene(rateStage());
			}});
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				
			}});
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	public Scene loseStage() 
	{
		
		GridPane root = new GridPane();
		Label label = new Label("You lose the game");
		Button button = new Button("Exit");
		root.setAlignment(Pos.CENTER);
		label.setId("faceLabel");
		root.setId("faceRoot");
		root.add(label, 0, 0);
		root.add(button, 0, 3);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
				
			}});
		Scene scene = new Scene(root, bounds.getWidth(),bounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
    public static void main( String[] args )
    {
    	
       launch(args);
    }
}
