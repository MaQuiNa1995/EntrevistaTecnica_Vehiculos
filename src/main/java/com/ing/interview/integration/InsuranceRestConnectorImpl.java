package com.ing.interview.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class InsuranceRestConnectorImpl implements InsuranceRestConnector {

	private static final Map<String, Integer> KYC = new HashMap<String, Integer>() {
		{
			put("PEUGEOT", 18);
			put("FIAT", 20);
			put("MERCEDES", 50);
		}
	};

	@Override
	public boolean isEligible(int age, String model) {
		return KYC.get(model) <= age;
	}

}
