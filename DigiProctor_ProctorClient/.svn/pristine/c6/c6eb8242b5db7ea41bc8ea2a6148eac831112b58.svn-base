package com.digiproctor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.digiproc.ProctorClientMainApp;
import com.digiproctor.utils.PlayMediaFirstUtil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

public class AuthenticateController implements Initializable {
	@FXML
	private Canvas canvasVideo = new Canvas(500, 500);

	public void initialize(URL url, ResourceBundle rb) {

		System.out
				.println("AuthenticateControllerProctorClientMainApp.intPort ppppppp=" + ProctorClientMainApp.intPort);

		if (ProctorClientMainApp.arrList.size() == 1) {
			System.out.println("hello1");

			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort);
		} else if (ProctorClientMainApp.arrList.size() == 2) {
			System.out.println("hello2");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort1);
		}

		else if (ProctorClientMainApp.arrList.size() == 3) {
			System.out.println("hello3");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort2);
		}

		else if (ProctorClientMainApp.arrList.size() == 4) {
			System.out.println("hello4");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort3);
		} else if (ProctorClientMainApp.arrList.size() == 5) {
			System.out.println("hello5");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort4);
		}

		else if (ProctorClientMainApp.arrList.size() == 6) {
			System.out.println("hello6");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort5);
		}

		else if (ProctorClientMainApp.arrList.size() == 7) {
			System.out.println("hello7");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort6);
		} else if (ProctorClientMainApp.arrList.size() == 8) {
			System.out.println("hello8");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort7);
		} else if (ProctorClientMainApp.arrList.size() == 9) {
			System.out.println("hello9");
			ProctorClientMainApp.objPlayMediaFirstUtil = new PlayMediaFirstUtil(canvasVideo,
					ProctorClientMainApp.intPort8);
		}

	}

}
