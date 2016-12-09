package com.myspring.aspect;

import org.springframework.stereotype.Component;

@Component
public class Audience {
	public void silenceCellPhones(){
		System.out.println("Silencing cell phones!");
	}
	public void takeSeats(){
		System.out.println("Taking Seats.");
	}
	public void applause(){
		System.out.println("CLAP CLAP CLAP!!");
	}
	public void demandRefund(){
		System.out.println("Demanding a refund!");
	}
}
