package com.digiproctor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.digiproc.ProctorClientMainApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ProctorClientControllerMonitor implements Initializable {

	private GraphicsContext gc;

	@FXML
	private Pane pane1 = new Pane();
	@FXML
	private Pane pane2 = new Pane();
	@FXML
	private Pane pane3 = new Pane();

	@FXML
	private void drawCanvas(ActionEvent event) {
		gc.setFill(Color.BLACK);
		gc.fillRect(10, 0, 500, 500);
	}

	public void initialize(URL url, ResourceBundle rb) {
		try {
			ProctorClientMainApp.objPlayMediaFirstUtil.stop();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// for (int i = 0; i < ProctorClientMainApp.arrList.size(); i++) {
		if (ProctorClientMainApp.arrList.size() == 1) {
			try {

				System.out.println("ProctorClientMainApp flagggggggg=" + ProctorClientMainApp.flag);
				System.out.println("ProctorClientMainApp flag11111111=" + ProctorClientMainApp.flag1);
				System.out.println("intPort=" + ProctorClientMainApp.intPort);
				System.out.println("intPort1=" + ProctorClientMainApp.intPort1);

				gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, 320, 230);
				pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

				/*
				 * ProctorClientMainApp.objPlayMediaUtil = new
				 * PlayMediaUtil(ProctorClientMainApp.canvasVideo1,
				 * ProctorClientMainApp.intPort);
				 */
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (ProctorClientMainApp.arrList.size() == 2) {
			try {

				System.out.println("ProctorClientMainApp flagggggggg=" + ProctorClientMainApp.flag);
				System.out.println("ProctorClientMainApp flag11111111=" + ProctorClientMainApp.flag1);
				System.out.println("intPort=" + ProctorClientMainApp.intPort);
				System.out.println("intPort1=" + ProctorClientMainApp.intPort1);

				gc = ProctorClientMainApp.canvasVideo1.getGraphicsContext2D();
				gc.setFill(Color.BLACK);
				gc.fillRect(0, 0, 320, 230);
				pane1.getChildren().add(ProctorClientMainApp.canvasVideo1);

				/*
				 * ProctorClientMainApp.objPlayMediaUtil = new
				 * PlayMediaUtil(ProctorClientMainApp.canvasVideo2,
				 * ProctorClientMainApp.intPort1);
				 */

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// }

	}

}
