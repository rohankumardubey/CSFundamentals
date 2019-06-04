package org.redquark.csfundamentals.designpatterns.structural.adapter;

/**
 * @Author Anirudh Sharma
 */
public class AdapterMain {

	public static void main(String[] args) {

		// Object for XPay
		XPay xPay = new XPayImpl();

		// Setting values
		xPay.setCreditCardNo("4789565874102365");
		xPay.setCustomerName("Max Warner");
		xPay.setCardExpMonth("09");
		xPay.setCardExpYear("25");
		xPay.setCardCVVNo((short) 235);
		xPay.setAmount(2565.23);

		// Getting object for YPay from the adapter class
		YPay yPay = new XPayToYPayAdapter(xPay);

		// Testing YPay object
		System.out.println(yPay.getCardOwnerName());
		System.out.println(yPay.getCustCardNo());
		System.out.println(yPay.getCardExpMonthDate());
		System.out.println(yPay.getCVVNo());
		System.out.println(yPay.getTotalAmount());
	}
}
