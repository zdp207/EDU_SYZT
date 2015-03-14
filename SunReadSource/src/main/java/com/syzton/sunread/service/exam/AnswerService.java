package com.syzton.sunread.service.exam;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.syzton.sunread.dto.exam.AnswerDTO;
import com.syzton.sunread.exception.exam.AnswerNotFoundException;
import com.syzton.sunread.model.exam.Answer;
import com.syzton.sunread.todo.model.Todo;

/**
 * 
 * @author XieYi
 *
 */
public interface AnswerService {

	 	public Answer add(AnswerDTO added);

	    public Answer deleteById(Long id) throws AnswerNotFoundException;

	    public List<Answer> findAll();

	    public Answer findById(Long id) throws AnswerNotFoundException;

	    public Answer update(AnswerDTO updated) throws AnswerNotFoundException;
}
