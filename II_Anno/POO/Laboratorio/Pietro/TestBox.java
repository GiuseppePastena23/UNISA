//Programma che crea una dialog box

import javax.swing.*;

public class TestBox {
	public static void main (String[] args) {
		String nome;
		nome = JOptionPane.showInputDialog ("Come ti chiami?");
		System.out.println ("Salve " + nome);
	}
}