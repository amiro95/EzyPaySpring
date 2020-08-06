package test.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.ribbon.proxy.annotation.Content;

import test.service.SubscriptionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(method = RequestMethod.GET, path = "/subscription")
	public Object getInvoice(@Content HttpServletResponse http, @RequestParam String subscriptionType,
			@RequestParam Double amount, @RequestParam Integer duration) {

		return subscriptionService.getInvoice(subscriptionType,amount,duration);

	}

}
