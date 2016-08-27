package com.digiproctor.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.digiproc.ProctorClientMainApp;
import com.digiproctor.utils.ApplicationPropertiesConfiguration;
import com.digiproctor.utils.PlayMediaUtil;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class ProctorClientController implements Initializable {

	/*
	 * PlayMediaUtil objPlayMediaUtil; PlayMediaFirstUtil objPlayMediaFirstUtil;
	 */

	private static final String SERVER_IP = ApplicationPropertiesConfiguration.getPropertiesValue()
			.getProperty("proctor.strServerIP");

	// private static final String SERVER_IP= "192.168.1.24";
	@FXML
	private WebView loginWebId = new WebView();
	@FXML
	private WebView monitorHeader = new WebView();
	@FXML
	private WebView headerWeb = new WebView();
	@FXML
	private WebView buttonsWeb = new WebView();
	@FXML
	private WebView leftpanelWeb = new WebView();
	@FXML
	private WebView footerPanelWeb = new WebView();
	@FXML
	private WebView monitorRightpanelFxID = new WebView();
	@FXML
	private HBox hbox;
	@FXML
	private VBox vbox;
	@FXML
	private Canvas canvasVideo = new Canvas(500, 500);

	@FXML
	private WebView webviewProctorClient = new WebView();

	private GraphicsContext gc;

	public static int counter = 0;

	@FXML
	private Pane pane1 = new Pane();
	@FXML
	private Pane pane2 = new Pane();
	@FXML
	private Pane pane3 = new Pane();
	@FXML
	private HBox hbox1 = new HBox();
	@FXML
	private HBox hbox2 = new HBox();
	@FXML
	private HBox hbox3 = new HBox();
	@FXML
	private HBox hbox4 = new HBox();
	@FXML
	private HBox hbox5 = new HBox();
	@FXML
	private HBox hbox6 = new HBox();

	@FXML
	private void drawCanvas(ActionEvent event) {
		gc.setFill(Color.BLACK);
		gc.fillRect(10, 0, 500, 500);
	}

	public void initialize(URL url, ResourceBundle rb) {

		if(ProctorClientMainApp.booleanLoginScreen==true){
			System.out.println("ProctorClientMainApp.booleanLoginScreen22222  ::" + ProctorClientMainApp.booleanLoginScreen);
			System.out.println("--------------------------logout-------------------------------");
			WebEngine webEngine = loginWebId.getEngine();
			webEngine.load("http://" + SERVER_IP + ":8080/digiproctor/");
			
			ProctorClientMainApp.booleanLoginScreen=false;
			
			webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window4 = (JSObject) webEngine.executeScript("window");
						window4.setMember("app", new ProctorLoginFx());
					}
				}
			});
			JSObject window4 = (JSObject) webEngine.executeScript("window");
			window4.setMember("app", new ProctorLoginFx());
			
		}
		else{
			//-----------------------
			
			if (ProctorClientMainApp.flag2 == true) {

				System.out.println("---------------------------------------------------------");

				try {
					ProctorClientMainApp.objPlayMediaFirstUtil.stop();

				} catch (Exception e1) {
				}

				// for(int i=1;i<=ProctorClientMainApp.arrList.size();i++){
				if (ProctorClientMainApp.arrList.size() == 1) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (ProctorClientMainApp.arrList.size() == 2) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (ProctorClientMainApp.arrList.size() == 3) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else if (ProctorClientMainApp.arrList.size() == 4) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (ProctorClientMainApp.arrList.size() == 5) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						gc = ProctorClientMainApp.canvasVideo5.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox2.getChildren().add(ProctorClientMainApp.canvasVideo5);

						ProctorClientMainApp.objPlayMediaUtil4 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo5,
								ProctorClientMainApp.intPort4);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				else if (ProctorClientMainApp.arrList.size() == 6) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						gc = ProctorClientMainApp.canvasVideo5.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox2.getChildren().add(ProctorClientMainApp.canvasVideo5);

						ProctorClientMainApp.objPlayMediaUtil4 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo5,
								ProctorClientMainApp.intPort4);

						gc = ProctorClientMainApp.canvasVideo6.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox3.getChildren().add(ProctorClientMainApp.canvasVideo6);

						ProctorClientMainApp.objPlayMediaUtil5 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo6,
								ProctorClientMainApp.intPort5);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				//
				else if (ProctorClientMainApp.arrList.size() == 7) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						gc = ProctorClientMainApp.canvasVideo5.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox2.getChildren().add(ProctorClientMainApp.canvasVideo5);

						ProctorClientMainApp.objPlayMediaUtil4 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo5,
								ProctorClientMainApp.intPort4);

						gc = ProctorClientMainApp.canvasVideo6.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox3.getChildren().add(ProctorClientMainApp.canvasVideo6);

						ProctorClientMainApp.objPlayMediaUtil5 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo6,
								ProctorClientMainApp.intPort5);

						gc = ProctorClientMainApp.canvasVideo7.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox4.getChildren().add(ProctorClientMainApp.canvasVideo7);

						ProctorClientMainApp.objPlayMediaUtil6 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo7,
								ProctorClientMainApp.intPort6);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				// --
				else if (ProctorClientMainApp.arrList.size() == 8) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						gc = ProctorClientMainApp.canvasVideo5.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox2.getChildren().add(ProctorClientMainApp.canvasVideo5);

						ProctorClientMainApp.objPlayMediaUtil4 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo5,
								ProctorClientMainApp.intPort4);

						gc = ProctorClientMainApp.canvasVideo6.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox3.getChildren().add(ProctorClientMainApp.canvasVideo6);

						ProctorClientMainApp.objPlayMediaUtil5 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo6,
								ProctorClientMainApp.intPort5);

						gc = ProctorClientMainApp.canvasVideo7.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox4.getChildren().add(ProctorClientMainApp.canvasVideo7);

						ProctorClientMainApp.objPlayMediaUtil6 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo7,
								ProctorClientMainApp.intPort6);

						gc = ProctorClientMainApp.canvasVideo8.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox5.getChildren().add(ProctorClientMainApp.canvasVideo8);

						ProctorClientMainApp.objPlayMediaUtil7 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo8,
								ProctorClientMainApp.intPort7);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				// 000
				else if (ProctorClientMainApp.arrList.size() == 9) {
					try {

						gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

						ProctorClientMainApp.objPlayMediaUtil = new PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
								ProctorClientMainApp.intPort);

						gc = ProctorClientMainApp.canvasVideo2.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane2.getChildren().add(ProctorClientMainApp.canvasVideo2);

						ProctorClientMainApp.objPlayMediaUtil1 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
								ProctorClientMainApp.intPort1);

						gc = ProctorClientMainApp.canvasVideo3.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						pane3.getChildren().add(ProctorClientMainApp.canvasVideo3);

						ProctorClientMainApp.objPlayMediaUtil2 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo3,
								ProctorClientMainApp.intPort2);

						gc = ProctorClientMainApp.canvasVideo4.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox1.getChildren().add(ProctorClientMainApp.canvasVideo4);

						ProctorClientMainApp.objPlayMediaUtil3 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo4,
								ProctorClientMainApp.intPort3);

						gc = ProctorClientMainApp.canvasVideo5.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox2.getChildren().add(ProctorClientMainApp.canvasVideo5);

						ProctorClientMainApp.objPlayMediaUtil4 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo5,
								ProctorClientMainApp.intPort4);

						gc = ProctorClientMainApp.canvasVideo6.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox3.getChildren().add(ProctorClientMainApp.canvasVideo6);

						ProctorClientMainApp.objPlayMediaUtil5 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo6,
								ProctorClientMainApp.intPort5);

						gc = ProctorClientMainApp.canvasVideo7.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox4.getChildren().add(ProctorClientMainApp.canvasVideo7);

						ProctorClientMainApp.objPlayMediaUtil6 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo7,
								ProctorClientMainApp.intPort6);

						gc = ProctorClientMainApp.canvasVideo8.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox5.getChildren().add(ProctorClientMainApp.canvasVideo8);

						ProctorClientMainApp.objPlayMediaUtil7 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo8,
								ProctorClientMainApp.intPort7);

						gc = ProctorClientMainApp.canvasVideo9.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						gc.fillRect(0, 0, 360, 220);
						hbox6.getChildren().add(ProctorClientMainApp.canvasVideo9);

						ProctorClientMainApp.objPlayMediaUtil8 = new PlayMediaUtil(ProctorClientMainApp.canvasVideo9,
								ProctorClientMainApp.intPort8);

						ProctorClientMainApp.flag2 = false;

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

			// }

			gc = canvasVideo.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(300, 0, 500, 500);

			WebEngine webEngine = loginWebId.getEngine();
			webEngine.load("http://" + SERVER_IP + ":8080/digiproctor/");

			WebEngine webEngineForMonitorHeader = monitorHeader.getEngine();
			webEngineForMonitorHeader.load("http://" + SERVER_IP + ":8080/digiproctor/monitor-headerFx");

			WebEngine webEngineForTopHeader = headerWeb.getEngine();
			webEngineForTopHeader.load("http://" + SERVER_IP + ":8080/digiproctor/top-headerFX");

			WebEngine webEngineForHeader = buttonsWeb.getEngine();
			webEngineForHeader.load("http://" + SERVER_IP + ":8080/digiproctor/headerFX");

			WebEngine webEngineForLeftPanel = leftpanelWeb.getEngine();
			webEngineForLeftPanel.load("http://" + SERVER_IP + ":8080/digiproctor/left-panelFX");

			WebEngine webEngineForFooter = footerPanelWeb.getEngine();
			webEngineForFooter.load("http://" + SERVER_IP + ":8080/digiproctor/footerFX");

			WebEngine webEngineForMonitorRightPanel = monitorRightpanelFxID.getEngine();
			webEngineForMonitorRightPanel.load("http://" + SERVER_IP + ":8080/digiproctor/monitor-rightpanelFx");

			webEngineForLeftPanel.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window = (JSObject) webEngineForLeftPanel.executeScript("window");
						window.setMember("app", new InnerClassForLeftPanelScrip());
					}
				}
			});

			JSObject window = (JSObject) webEngineForLeftPanel.executeScript("window");
			window.setMember("app", new InnerClassForLeftPanelScrip());

			webEngineForFooter.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window1 = (JSObject) webEngineForFooter.executeScript("window");
						window1.setMember("app", new InnerClassForFooterScrip());
					}
				}
			});
			JSObject window1 = (JSObject) webEngineForFooter.executeScript("window");
			window1.setMember("app", new InnerClassForFooterScrip());

			webEngineForMonitorHeader.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window2 = (JSObject) webEngineForMonitorHeader.executeScript("window");
						window2.setMember("app", new InnerClassForMonitorHeaderScrip());
					}
				}
			});
			JSObject window2 = (JSObject) webEngineForMonitorHeader.executeScript("window");
			window2.setMember("app", new InnerClassForMonitorHeaderScrip());

			webEngineForTopHeader.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window3 = (JSObject) webEngineForTopHeader.executeScript("window");
						window3.setMember("app", new InnerClassForTopHeaderAuScrip());
					}
				}
			});
			JSObject window3 = (JSObject) webEngineForTopHeader.executeScript("window");
			window3.setMember("app", new InnerClassForTopHeaderAuScrip());

			webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
					if (newState == State.SUCCEEDED) {
						JSObject window4 = (JSObject) webEngine.executeScript("window");
						window4.setMember("app", new ProctorLoginFx());
					}
				}
			});
			JSObject window4 = (JSObject) webEngine.executeScript("window");
			window4.setMember("app", new ProctorLoginFx());
			
			//-----------------------
		}
		
		
		
	}

	public class InnerClassForLeftPanelScrip { // canvasVideo = new Canvas(320,
												// 240);
		public void callFromJavascript(String msg) throws Exception {
			ProctorClientMainApp.arrList.add(msg);
			System.out.println("size of array: " + ProctorClientMainApp.arrList.size());
			if (ProctorClientMainApp.arrList.size() == 1) {

				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);
				// int rcvPort1 = firewallPuncher(proctorPort+2, mssIp,
				// mssPort);

				// ProctorClientMainApp.intPort1 = rcvPort1;
				ProctorClientMainApp.intPort = rcvPort;

				ProctorClientMainApp.flag3 = false;

				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 2) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);
				// int rcvPort1 = firewallPuncher(proctorPort+2, mssIp,
				// mssPort);

				ProctorClientMainApp.intPort1 = rcvPort;
				// ProctorClientMainApp.intPort1 = rcvPort1;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 3) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort2 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 4) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort3 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 5) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort4 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 6) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort5 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			else if (ProctorClientMainApp.arrList.size() == 7) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort6 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 8) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort7 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (ProctorClientMainApp.arrList.size() == 9) {
				String ssIdAll[] = msg.split("\\$");
				System.out.println("This is msg : " + ssIdAll.toString());
				String ssid = ssIdAll[0];
				String proctorIp = ssIdAll[1];
				String proctorport = ssIdAll[2];
				String mssIp = ssIdAll[3];
				String mssport = ssIdAll[4];
				int proctorPort = Integer.parseInt(proctorport);
				int mssPort = Integer.parseInt(mssport);
				int rcvPort = firewallPuncher(proctorPort, mssIp, mssPort);

				ProctorClientMainApp.intPort8 = rcvPort;
				try {
					URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/1x1_Fxml.fxml");
					GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
					if (counter == 0) {
						vbox.getChildren().add(paneTwo);
						counter = 1;
					} else {
						vbox.getChildren().clear();
						vbox.getChildren().add(paneTwo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public class InnerClassForFooterScrip {
		public void handleAuthorizationButton(String msg) throws Exception {
			ProctorClientMainApp.flag2 = true;
			System.out.println("vinnnnnnnnnnnnnnnnnnn=" + ProctorClientMainApp.arrList.size());
			URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/Proctor_Client_Monitor_Fxml.fxml");
			GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
			BorderPane border = ProctorClientMainApp.getRoot();
			border.setCenter(paneTwo);

		}
	}

	public class InnerClassForMonitorHeaderScrip {
		public void getAuthenticateTab(String msg) throws Exception {

			System.out.println("array size in fxml=" + ProctorClientMainApp.arrList.size());
			// ProctorClientMainApp.objPlayMediaUtil.stop();

			if (ProctorClientMainApp.arrList.size() == 1) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
			} else if (ProctorClientMainApp.arrList.size() == 2) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
			} else if (ProctorClientMainApp.arrList.size() == 3) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
			} else if (ProctorClientMainApp.arrList.size() == 4) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
			} else if (ProctorClientMainApp.arrList.size() == 5) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
				ProctorClientMainApp.objPlayMediaUtil4.stop();
			} else if (ProctorClientMainApp.arrList.size() == 6) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
				ProctorClientMainApp.objPlayMediaUtil4.stop();
				ProctorClientMainApp.objPlayMediaUtil5.stop();
			}

			else if (ProctorClientMainApp.arrList.size() == 7) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
				ProctorClientMainApp.objPlayMediaUtil4.stop();
				ProctorClientMainApp.objPlayMediaUtil5.stop();
				ProctorClientMainApp.objPlayMediaUtil6.stop();
			} else if (ProctorClientMainApp.arrList.size() == 8) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
				ProctorClientMainApp.objPlayMediaUtil4.stop();
				ProctorClientMainApp.objPlayMediaUtil5.stop();
				ProctorClientMainApp.objPlayMediaUtil6.stop();
				ProctorClientMainApp.objPlayMediaUtil7.stop();
			} else if (ProctorClientMainApp.arrList.size() == 9) {
				ProctorClientMainApp.objPlayMediaUtil.stop();
				ProctorClientMainApp.objPlayMediaUtil1.stop();
				ProctorClientMainApp.objPlayMediaUtil2.stop();
				ProctorClientMainApp.objPlayMediaUtil3.stop();
				ProctorClientMainApp.objPlayMediaUtil4.stop();
				ProctorClientMainApp.objPlayMediaUtil5.stop();
				ProctorClientMainApp.objPlayMediaUtil6.stop();
				ProctorClientMainApp.objPlayMediaUtil7.stop();
				ProctorClientMainApp.objPlayMediaUtil8.stop();
			}

			URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/Proctor_Client_Fxml1.fxml");
			GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
			BorderPane border = ProctorClientMainApp.getRoot();
			border.setCenter(paneTwo);

			System.out.println("hello vinod3");

		}
	}

	public class ProctorLoginFx {
		public void proctorLoginButton(String msg) throws Exception {
			System.out.println("msg  ::" + msg);
			URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/Proctor_Client_Fxml1.fxml");
			GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
			BorderPane border = ProctorClientMainApp.getRoot();
			border.setCenter(paneTwo);

			System.out.println("hello vinod1");

		}
	}

	public class InnerClassForTopHeaderAuScrip {
		public void getMonitorTab(String msg) throws Exception {
			
			ProctorClientMainApp.flag2 = true;
			System.out.println("vinnnnnnnnnnnnnnnnnnn=" + ProctorClientMainApp.arrList.size());
			System.out.println("msg  ::" + msg);
			URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/Proctor_Client_Monitor_Fxml.fxml");
			GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
			BorderPane border = ProctorClientMainApp.getRoot();
			border.setCenter(paneTwo);

			System.out.println("hello vinod2");

		}
		public void getInitiateLogout(String msg) throws Exception {
			System.out.println("ProctorClientMainApp.booleanLoginScreen111  ::" + msg);
			ProctorClientMainApp.booleanLoginScreen=true;
			URL paneTwoUrl = getClass().getResource("/com/digiproctor/resources/fxml/ProctorClientLoginFxml.fxml");
			GridPane paneTwo = FXMLLoader.load(paneTwoUrl);
			BorderPane border = ProctorClientMainApp.getRoot();
			border.setCenter(paneTwo);
		}
		
	}

	public int firewallPuncher(int proctorPort, String mssIp, int mssPort) throws Exception {
		System.out.println("Going to puncher the firewal");
		int rcvport = proctorPort + 1;
		String udpcmd = "UDPClient_x86.exe " + proctorPort + " " + rcvport + " " + mssIp + " " + mssPort;
		ProcessBuilder p = new ProcessBuilder("CMD", "/C", udpcmd);
		Process cmd = p.start();
		System.out.println("Start");
		Thread.sleep(2000);
		System.out.println("End");
		System.out.println("end to puncher the firewal");
		return rcvport;
	}

}
