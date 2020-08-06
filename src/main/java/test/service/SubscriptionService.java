package test.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.response.GetInvoiceResponse;

@Transactional
@Service
public class SubscriptionService {

	public GetInvoiceResponse getInvoice(String subscriptionType, Double amount, Integer duration) {

		GetInvoiceResponse response = new GetInvoiceResponse();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate start = LocalDate.now();

		List<String> totalDates = new ArrayList<>();
		for (int i = 0; i < duration; i++) {
			totalDates.add(dtf.format(start));
			if (subscriptionType.equalsIgnoreCase("daily")) {
				start = start.plusDays(1);
			} else if (subscriptionType.equalsIgnoreCase("weekly")) {
				start = start.plusWeeks(1);
			} else {
				start = start.plusMonths(1);
			}

		}
		String strAmt = String.valueOf(amount);
		response.setAmount("MYR" +strAmt);
		response.setSubscriptionType(subscriptionType);
		response.setInvoiceDates(totalDates);
		return response;

	}

}
