package test.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class GetInvoiceResponse {
	private String amount;

	private String subscriptionType;

	private List<String> invoiceDates;

}
