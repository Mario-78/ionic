package com.mario.testProject.servisces;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.mario.testProject.domain.Cliente;
import com.mario.testProject.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);	
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
