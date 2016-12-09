package com.myspring.perform;

import org.springframework.stereotype.Component;

@Component
public class Dance implements Performance{

	@Override
	public void perform() {
		System.out.println("Two people are dancing!!");
		
	}

}
