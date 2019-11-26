package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reservation reservation;
		Date checkIn;
		Date checkOut;
		
		try {
			System.out.print("Room number:");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());
			reservation = new Reservation(number, checkIn, checkOut);
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
			System.out.println();
			System.out.println("Entre com a data para atualizar:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+reservation);
		}
		catch(ParseException a) {
			System.out.println("Formato de data inválido! Digite a data separada por aspas e sem espaços.");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
}
}
