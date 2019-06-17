package org.redquark.csfundamentals.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author Anirudh Sharma
 */
public class AudioFileHandler implements Handler {

	private Handler handler;
	private String handlerName;

	public AudioFileHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void processFile(File file) {
		if (file.getFileType().equalsIgnoreCase("audio")) {
			System.out.println("Processing and saving audio file by: " + handlerName);
		} else if (handler != null) {
			System.out.println(handlerName + " forwards request to: " + handler.getHandlerName());
			handler.processFile(file);
		} else {
			System.out.println("File not supported");
		}
	}

	@Override
	public String getHandlerName() {
		return handlerName;
	}
}
