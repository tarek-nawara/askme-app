package edu.askme.controllers.feedback;

public class FeedBack<T> {
	private ResponseStatus status;
	private T data;

	public FeedBack() {
	}

	public FeedBack(ResponseStatus status, T data) {
		this.status = status;
		this.data = data;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeedBack [status=");
		builder.append(status);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
