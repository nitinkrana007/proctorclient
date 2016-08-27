package com.digiproc;

import java.net.URL;
import java.util.ArrayList;

import com.digiproctor.utils.PlayMediaFirstUtil;
import com.digiproctor.utils.PlayMediaUtil;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class ProctorClientMainApp extends Application {
	/**
	 * Lightweight JavaFX canvas, the video is rendered here.
	 */

	private static BorderPane root = new BorderPane();

	private Stage stage;

	// PlayMediaUtil1
	public static PlayMediaUtil objPlayMediaUtil;
	public static PlayMediaFirstUtil objPlayMediaFirstUtil;
	public static PlayMediaUtil objPlayMediaUtil1;
	public static PlayMediaUtil objPlayMediaUtil2;

	public static PlayMediaUtil objPlayMediaUtil3;
	public static PlayMediaUtil objPlayMediaUtil4;
	public static PlayMediaUtil objPlayMediaUtil5;

	public static PlayMediaUtil objPlayMediaUtil6;
	public static PlayMediaUtil objPlayMediaUtil7;
	public static PlayMediaUtil objPlayMediaUtil8;

	public static String VIDEO_FILE = "rtp://127.0.0.1:";

	public static boolean flag = false;
	public static int intPort1 = 0;
	public static int intPort2 = 0;
	public static int intPort3 = 0;
	public static int intPort4 = 0;
	public static int intPort5 = 0;
	public static int intPort6 = 0;
	public static int intPort7 = 0;
	public static int intPort8 = 0;
	public static int intPort9 = 0;
	public static int intPort = 0;

	public static boolean flag1 = false;
	public static boolean flag2 = false;
	public static boolean flag3 = false;
	
	public static boolean booleanLoginScreen = false;

	public static ArrayList<String> arrList = new ArrayList<String>();

	public static Canvas canvasVideo1 = new Canvas(320, 230);
	public static Canvas canvasVideo2 = new Canvas(320, 230);
	public static Canvas canvasVideo3 = new Canvas(320, 230);
	public static Canvas canvasVideo4 = new Canvas(320, 230);
	public static Canvas canvasVideo5 = new Canvas(320, 230);
	public static Canvas canvasVideo6 = new Canvas(320, 230);
	public static Canvas canvasVideo7 = new Canvas(320, 230);
	public static Canvas canvasVideo8 = new Canvas(320, 230);
	public static Canvas canvasVideo9 = new Canvas(320, 230);

	/**
	 *
	 */
	private Scene scene;

	public static BorderPane getRoot() {
		return root;
	}

	public ProctorClientMainApp() {
	}

	@Override
	public final void start(Stage primaryStage) throws Exception {

		this.stage = primaryStage;

		stage.setTitle("vlcj JavaFX Direct Rendering Test");
		URL baseFxml = getClass().getResource("/com/digiproctor/resources/fxml/Base_Fxml.fxml");
		root = FXMLLoader.load(baseFxml);
		GridPane authenticationFxml = FXMLLoader
				.load(getClass().getResource("/com/digiproctor/resources/fxml/ProctorClientLoginFxml.fxml"));
		root.setCenter(authenticationFxml);
		scene = new Scene(root);

		primaryStage.getIcons().add(new Image("com/digiproctor/resources/images/DG.png"));
		primaryStage.setTitle("DigiProctor ProctorClient");
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.show();
		primaryStage.setFullScreenExitHint("");

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				Platform.exit();
				System.exit(0);
			}
		});

	}

	public static void main(final String[] args) {
		String path = "vlc";
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), path);
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		Application.launch(args);
	}

}
