package org.redquark.csfundamentals.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author Anirudh Sharma
 */
public class DocFileHandler implements Handler {

	private Handler handler;
	private String handlerName;

	public DocFileHandler(String handlerName) {
		this.handlerName = handlerName;
	}

	@Override
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void processFile(File file) {
		if (file.getFileType().equalsIgnoreCase("doc")) {
			System.out.println("Processing and saving doc file by: " + handlerName);
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
