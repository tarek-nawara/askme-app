package edu.askme.controllers.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionDTO {
	@NotNull
	@Size(max = 100)
	private String content;

	@NotNull
	@Size(max = 100)
	private String answer;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionDTO [content=");
		builder.append(content);
		builder.append(", answer=");
		builder.append(answer);
		builder.append("]");
		return builder.toString();
	}

}
