package edu.askme.controllers.dto.utils;

import edu.askme.controllers.dto.QuestionDTO;
import edu.askme.controllers.dto.UserDTO;
import edu.askme.dao.entities.Question;
import edu.askme.dao.entities.User;

public class DTOUtils {

    private DTOUtils() {
    }


    public static UserDTO newUserDTOInstanceFrom(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static QuestionDTO newQuestionInstanceFrom(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setContent(question.getContent());
        questionDTO.setAnswer(question.getAnswer());
        return questionDTO;
    }
}
