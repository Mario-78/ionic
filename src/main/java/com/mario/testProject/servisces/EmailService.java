package com.mario.testProject.servisces;

import org.springframework.mail.SimpleMailMessage;

import com.mario.testProject.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
