package edu.askme.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private State state;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;

	@Column(nullable = false)
	private String content;
	private String answer;

	protected Question() {
	}

	public Question(String content, String answer) {
		this.content = content;
		this.answer = answer;
		this.state = State.ANSWERED;
	}

	public Question(String content) {
		this(content, "");
		this.state = State.UNANSWERED;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [id=");
		builder.append(id);
		builder.append(", state=");
		builder.append(state);
		builder.append(", content=");
		builder.append(content);
		builder.append(", answer=");
		builder.append(answer);
		builder.append("]");
		return builder.toString();
	}

}
