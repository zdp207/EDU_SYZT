package com.syzton.sunread.dto.exam;

import com.syzton.sunread.model.exam.Answer;
import com.syzton.sunread.model.exam.CapacityQuestion;
import com.syzton.sunread.model.exam.ObjectiveAnswer;
import com.syzton.sunread.model.exam.Option;

public class CapacityAnswerDTO  {

	protected CapacityQuestion question;
	
	protected Long studentId;
	
	private Option option;

	public Answer FromOTD(){
		ObjectiveAnswer answer = new ObjectiveAnswer();
		answer.setOption(option);
		answer.setQuestion(question);
		answer.setStudentId(studentId);
		return answer;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public CapacityQuestion getQuestion() {
		return question;
	}

	public void setQuestion(CapacityQuestion question) {
		this.question = question;
	}
	
	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}
}
