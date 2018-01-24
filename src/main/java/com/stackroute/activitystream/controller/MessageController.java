package com.stackroute.activitystream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

/*
 * Annotate the class with @Controller annotation.@Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 */
@Controller
public class MessageController {

	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement two functionalities. They are as following:
	 * 
	 * 1. display the list of existing messages from the database. Each message
	 * should contain senderName, message, and timestamp 2. send a message which
	 * should contain the senderName, message, and timestamp.
	 * 
	 */

	/*
	 * Autowiring should be implemented for the MessageDAO and Message. Please
	 * note that we should not create any object using the new keyword
	 */

	@Autowired
	MessageDAO messageDAO;
	@Autowired
	Message message;

	/*
	 * Define a handler method to read the existing messages from the database
	 * and add it to the ModelMap which is an implementation of Map for use when
	 * building model data for use with views. it should map to the default URL
	 * i.e. "/"
	 */
	@GetMapping(value = { "/" })
	public String home(ModelMap model) {
		model.addAttribute("messages", messageDAO.getMessages());
		return "index";
	}

	/*
	 * Define a handler method which will read the senderName and message from
	 * request parameters and save the message in message table in database.
	 * Please note that the timestamp should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving
	 * the message, it should show the same along with existing messages. Hence,
	 * reading messages has to be done here again and the retrieved messages
	 * object should be sent back to the view using ModelMap This handler method
	 * should map to the URL "/sendMessage".
	 */
	@PostMapping(value = "/sendMessage")
	public String sendMessage(@RequestParam("sender") String sender, @RequestParam("message") String msg,
			ModelMap model) {

		if (sender.isEmpty() || msg.isEmpty()) {
			model.addAttribute("messages", messageDAO.getMessages());
			return "index";
		}
		message.setMessage(msg);
		message.setSenderName(sender);
		message.setPostedDate();
		messageDAO.sendMessage(message);
		return "redirect:/";

	}

}
