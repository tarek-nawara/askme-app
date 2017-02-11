package edu.askme.services.services;

import edu.askme.controllers.dto.UserDTO;

public interface EmailService {

    public void sendEmail(UserDTO user);
}
