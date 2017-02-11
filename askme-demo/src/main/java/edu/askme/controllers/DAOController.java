package edu.askme.controllers;

import edu.askme.controllers.dto.UserDTO;
import edu.askme.controllers.dto.utils.DTOUtils;
import edu.askme.controllers.exceptions.UserNotFoundException;
import edu.askme.controllers.feedback.FeedBack;
import edu.askme.controllers.feedback.ResponseStatus;
import edu.askme.dao.domain.UserRepository;
import edu.askme.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DAOController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public FeedBack<UserDTO> getUserByName(@PathVariable String userName) {
        List<User> userList = userRepository.findByUsername(userName);
        if (userList == null || userList.size() == 0) {
            throw new UserNotFoundException();
        }
        User user = userList.get(0);
        UserDTO userDTO = DTOUtils.newUserDTOInstanceFrom(user);
        FeedBack<UserDTO> userDTOFeedBack = new FeedBack<>(ResponseStatus.SUCCESS, userDTO);
        return userDTOFeedBack;
    }

    //TODO add question, answer, user
    //GET


}
