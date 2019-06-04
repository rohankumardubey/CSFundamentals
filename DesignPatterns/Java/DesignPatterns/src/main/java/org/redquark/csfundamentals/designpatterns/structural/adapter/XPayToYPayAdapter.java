package org.redquark.csfundamentals.designpatterns.structural.adapter;

/**
 * @Author Anirudh Sharma
 */
public class XPayToYPayAdapter implements YPay {

	private final XPay xPay;
	private String custCardNo;
	private String cardOwnerName;
	private String cardExpMonthDate;
	private Integer cVVNo;
	private Double totalAmount;

	public XPayToYPayAdapter(XPay xPay) {
		this.xPay = xPay;
		setProperties();
	}

	private void setProperties() {
		setCardOwnerName(this.xPay.getCustomerName());
		setCustCardNo(this.xPay.getCreditCardNo());
		setCardExpMonthDate(this.xPay.getCardExpMonth() + "/" + this.xPay.getCardExpYear());
		setCVVNo(this.xPay.getCardCVVNo().intValue());
		setTotalAmount(this.xPay.getAmount());
	}

	@Override
	public String getCustCardNo() {
		return custCardNo;
	}

	@Override
	public void setCustCardNo(String custCardNo) {
		this.custCardNo = custCardNo;
	}

	@Override
	public String getCardOwnerName() {
		return cardOwnerName;
	}

	@Override
	public void setCardOwnerName(String cardOwnerName) {
		this.cardOwnerName = cardOwnerName;
	}

	@Override
	public String getCardExpMonthDate() {
		return cardExpMonthDate;
	}

	@Override
	public void setCardExpMonthDate(String cardExpMonthDate) {
		this.cardExpMonthDate = cardExpMonthDate;
	}

	public Integer getCVVNo() {
		return cVVNo;
	}

	public void setCVVNo(Integer cVVNo) {
		this.cVVNo = cVVNo;
	}

	@Override
	public Double getTotalAmount() {
		return totalAmount;
	}

	@Override
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
