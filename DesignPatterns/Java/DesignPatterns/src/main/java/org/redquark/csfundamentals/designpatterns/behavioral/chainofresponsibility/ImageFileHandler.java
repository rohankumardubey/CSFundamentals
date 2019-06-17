package org.redquark.csfundamentals.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author Anirudh Sharma
 */
public class ImageFileHandler implements Handler {

	private Handler handler;
	private String handlerName;

	public ImageFileHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void processFile(File file) {
		if (file.getFileType().equalsIgnoreCase("image")) {
			System.out.println("Processing and saving image file by: " + handlerName);
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
