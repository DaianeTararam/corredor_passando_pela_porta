//@author Daiane Tararam
package controller;

import java.util.concurrent.Semaphore;

//Quatro pessoas caminham, cada uma em um corredor diferente. Os 4 corredores terminam
//em uma única porta. Apenas 1 pessoa pode cruzar a porta, por vez. Considere que cada
//corredor tem 200m. e cada pessoa anda de 4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
//para abrir e cruzar a porta. Faça uma aplicação em java que simule essa situação.

public class Corredores extends Thread{
	private String pessoa;
	private int distanciaTotal = 200;
	private int velocidade = (int)((Math.random() * (6 - 4) + 1)+ 4);
	private static Semaphore porta = new Semaphore(1);
	private static Semaphore corredor = new Semaphore(4);
	private static boolean portaOcupada = false;
	
	public Corredores(String pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public void run() {
		try {
			corredor.acquire();
			caminhar();
			passarPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			corredor.release();
		}
		
	}

	private void caminhar() {
		int distancia = 0;
		while (distancia < distanciaTotal) {
			distancia += velocidade;
		}
		if(portaOcupada == true) {
			try {
				sleep(distancia);
				System.out.println(pessoa+ " está esperando a passagem...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

	private void passarPorta() {
		portaOcupada = true;
		try {
			porta.acquire();
			sleep((int)((Math.random() * (2 - 1 + 1))+1));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			porta.release();
		}
		System.out.println(pessoa + " PASSOU PELA PORTA.");
		portaOcupada = false;
		
		
	}
	
}
