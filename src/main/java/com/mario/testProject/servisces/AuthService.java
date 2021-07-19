package com.mario.testProject.servisces;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mario.testProject.domain.Cliente;
import com.mario.testProject.repositores.ClienteRepository;
import com.mario.testProject.servisces.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder be;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
	
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado!");
		}
		
		String newPass = newPasswor();
		cliente.setSenha(be.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
		
	}

	private String newPasswor() {
		char[] vet = new char[10];
		for(int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {//gera um dígito
			return (char) (rand.nextInt(10) + 48);
		}
		if(opt == 1) {//gera uma letra maiúscula
			return (char) (rand.nextInt(26) + 65);
		}
		if(opt == 2) {//gera um minúscula
			return (char) (rand.nextInt(26) + 97);
		}
		return 0;
	}

}
