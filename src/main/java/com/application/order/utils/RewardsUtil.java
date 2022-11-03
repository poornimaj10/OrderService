package com.application.order.utils;

import org.springframework.stereotype.Component;

@Component
public class RewardsUtil {

//	public static int balanceRewards(int existing, int used) {
//		return (existing - used);
//	}
	
	/**
	 * 1 point for every $ post 50$ 
	 * plus 
	 * 1 additional point for every $100 from there on
	 * @param total
	 * @return
	 */
//	public static int calcRewards(int total) {
//		if(total > 0) {
//			return (total - 50)*1+(total-100)*1;
//		}else {
//			return 0;
//		}
//		
//	}
	
	/**
	 * 1 point for every $ post 50$ 
	 * plus 
	 * 1 additional point for every $100 from there on
	 * @param total
	 * @return
	 */
	public static int calcRewards(int total, int minRewardAmt, int point, int addonAmt, int addonPoint) {
		if(total > 0) {
			return (total - minRewardAmt)*point+(total-addonAmt)*addonPoint;
		}else {
			return 0;
		}
		
	}
	
}
