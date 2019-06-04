package org.redquark.csfundamentals.designpatterns.structural.adapter;

/**
 * @Author Anirudh Sharma
 */
public interface YPay {

	String getCustCardNo();

	void setCustCardNo(String custCardNo);

	String getCardOwnerName();

	void setCardOwnerName(String cardOwnerName);

	String getCardExpMonthDate();

	void setCardExpMonthDate(String cardExpMonthDate);

	Integer getCVVNo();

	void setCVVNo(Integer cVVNo);

	Double getTotalAmount();

	void setTotalAmount(Double totalAmount);
}
