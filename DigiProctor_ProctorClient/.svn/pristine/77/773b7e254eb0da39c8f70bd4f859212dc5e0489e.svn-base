package com.digiproctor.utils;


import java.nio.ByteBuffer;

import com.sun.jna.Memory;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritablePixelFormat;
import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent;
import uk.co.caprica.vlcj.player.direct.BufferFormat;
import uk.co.caprica.vlcj.player.direct.BufferFormatCallback;
import uk.co.caprica.vlcj.player.direct.DefaultDirectMediaPlayer;
import uk.co.caprica.vlcj.player.direct.format.RV32BufferFormat;
public class PlayMediaUtil1 {
	
	static int videoSource=0;
	
	//private static final String VIDEO_FILE = "Dillagi.mp4";
	private static String VIDEO_FILE = "";//"rtp://127.0.0.1:"+videoSource;

	private static final boolean useSourceSize = false;
	private static final int WIDTH = 320;

	private static final int HEIGHT = 230;

	private PixelWriter pixelWriter;
	private final AnimationTimer timer;
	
	private Canvas canvasVideo = new Canvas(320, 230);
	private String msg;

	/**
	 * Pixel format.
	 */
	private WritablePixelFormat<ByteBuffer> pixelFormat;
	private DirectMediaPlayerComponent mediaPlayerComponent;
	
	
	//public PlayMediaUtil(Canvas canvasVideo1,int rcvPort) {
	public PlayMediaUtil1(Canvas canvasVideo1,int intPort) {
		
		this.canvasVideo=canvasVideo1;		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				renderFrame();
			}
		};
		
		VIDEO_FILE = "rtp://127.0.0.1:"+intPort;
		//VIDEO_FILE = "F://sample.mp4";
		pixelWriter = canvasVideo.getGraphicsContext2D().getPixelWriter();
		pixelFormat = PixelFormat.getByteBgraInstance();
		mediaPlayerComponent = new TestMediaPlayerComponent();
		//VIDEO_FILE = "rtp://127.0.0.1:"+rcvPort;		
		System.out.println("VIDEO_FILE="+VIDEO_FILE);		
		mediaPlayerComponent.getMediaPlayer().playMedia(VIDEO_FILE);
		mediaPlayerComponent.getMediaPlayer().setPosition(0.7f);
		startTimer();
	}
	
	
	protected void startTimer() {
		timer.start();
	}

	protected void stopTimer() {
		timer.stop();
	}
	public final void start() throws Exception {
		stopTimer();
		mediaPlayerComponent.getMediaPlayer().start();		
	}
	public final void stop() throws Exception {
		stopTimer();
		mediaPlayerComponent.getMediaPlayer().stop();
		mediaPlayerComponent.getMediaPlayer().release();
	}
	public final void pause() throws Exception {		
		mediaPlayerComponent.getMediaPlayer().pause();;
		mediaPlayerComponent.getMediaPlayer().release();
	}

	private class TestMediaPlayerComponent extends DirectMediaPlayerComponent {

		public TestMediaPlayerComponent() {
			super(new TestBufferFormatCallback());
		}
	}

	private class TestBufferFormatCallback implements BufferFormatCallback {

		public BufferFormat getBufferFormat(int sourceWidth, int sourceHeight) {
			final int width;
			final int height;
			if (useSourceSize) {
				width = sourceWidth;
				height = sourceHeight;
			} else {
				width = WIDTH;
				height = HEIGHT;
			}
			Platform.runLater(new Runnable() {
				public void run() {
					canvasVideo.setWidth(width);
					canvasVideo.setHeight(height);

				}
			});
			return new RV32BufferFormat(width, height);
		}
	}

	
	protected final void renderFrame() {
		Memory[] nativeBuffers = mediaPlayerComponent.getMediaPlayer().lock();
		if (nativeBuffers != null) {
			Memory nativeBuffer = nativeBuffers[0];
			if (nativeBuffer != null) {
				ByteBuffer byteBuffer = nativeBuffer.getByteBuffer(0, nativeBuffer.size());
				BufferFormat bufferFormat = ((DefaultDirectMediaPlayer) mediaPlayerComponent.getMediaPlayer())
						.getBufferFormat();
				if (bufferFormat.getWidth() > 0 && bufferFormat.getHeight() > 0) {
					pixelWriter.setPixels(0, 0, bufferFormat.getWidth(), bufferFormat.getHeight(), pixelFormat,
							byteBuffer, bufferFormat.getPitches()[0]);
				}
			}
		}
		mediaPlayerComponent.getMediaPlayer().unlock();
	}
	

}
