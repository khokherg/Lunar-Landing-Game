package application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class MainController {
	@FXML private Button btnThrust;
	@FXML private Button btnStart;
	@FXML private Button btnPrint;
	@FXML private Label height;
	@FXML private Label velocity;
	@FXML private Label fuel;
	@FXML private ProgressBar fuelBar;
	@FXML private ProgressBar heightBar;
	private PhysicsEngine obj = new PhysicsEngine();

	//initialize method is automatically called when the window opens

	@FXML private void initialize()
	{

		Timeline _timer = new Timeline(new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent event)
			{
				onTimer();
			}}));
		_timer.setCycleCount(Timeline.INDEFINITE);
		_timer.play();

		//Attaching the event handler for Start button

		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onStartClicked();
			}
		});

		//Attaching the event handler for Print Log button

		btnPrint.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onPrintClicked();
			}
		});
	}

	public void onTimer()

	{
		boolean result = obj.nextStep(btnThrust.isPressed());

		//Displays the values of height, velocity and fuel in GUI

		height.setText(""+ obj.getHeight());
		velocity.setText(""+ obj.getVelocity());
		fuel.setText(""+ obj.getFuel());

		//Sets the progress bar

		fuelBar.setProgress(obj.getFuel()/100);
		heightBar.setProgress(obj.getHeight()/500);

		//Checks if the landing is successful or not

		if(result==true)
		{
			if(-(obj.getVelocity())<obj.SAFE_LANDING_SPEED)
			{
				Alert alert = new Alert(AlertType.INFORMATION,
						"Congratulations, You landed successfully!!");
				alert.show();

			}

			else

			{
				Alert alert = new Alert(AlertType.ERROR,
						"You Crashed!!");
				alert.show();

			}
		}
	}


	public void onStartClicked()

	{
		obj.start();   // calls the start method in Physics Engine Class

	}
	public void onPrintClicked()

	{

		obj.printMotionLog();   // Calls the printMotionLog method in Physics Engine class

	}

}
