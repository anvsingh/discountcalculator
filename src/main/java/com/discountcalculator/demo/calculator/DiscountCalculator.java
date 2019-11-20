package com.discountcalculator.demo.calculator;

import org.springframework.context.annotation.Configuration;

/**
 * @author anujv
 *
 */
@Configuration
public class DiscountCalculator {

	int percentDiscount=0;
	float percentDiscountAmount=0.0f;
	int netDisocuntAmount=0;
	/**
	 *  loyal is for user which has been a customer for over 2 years
	 */
	/**
	 * @param custType
	 * @param orderType
	 * @param initialBill
	 * @return
	 */
	public int amountPayable(String custType,String orderType,float initialBill ) {
		if(!orderType.equalsIgnoreCase("groceries")) {
			percentDiscount=checkPercentageDiscount(custType);
			System.out.println("percent discount"+ percentDiscount);
		}
		if(percentDiscount != 0) {
			percentDiscountAmount=	calculateDiscount(percentDiscount,initialBill);
		}
		
		netDisocuntAmount=	calculateNetDiscount(initialBill);
		return (int) (initialBill-percentDiscountAmount-netDisocuntAmount);
		
	}

	private int calculateNetDiscount(float initialBill) {
		
		return (int) (5*(initialBill/100));
		
		
	}

	private float calculateDiscount(float percent, float initialBill) {
		
		return (initialBill*(percent/100.0f));
		
	}

	private int checkPercentageDiscount(String custCategory) {
		
		switch(custCategory)
		{
		case "employee":
			percentDiscount=30;
			break;
		case "affiliate":
			percentDiscount=10;
			break;
		case "loyal":
			percentDiscount=5;
			break;
		default:
			percentDiscount=0;	
		}
		return percentDiscount;
		
	}
}
