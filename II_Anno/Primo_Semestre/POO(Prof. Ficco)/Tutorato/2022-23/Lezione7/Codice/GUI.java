package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Lottatore;
import core.LottatoreVolante;
import core.Mago;
import core.Player;

public class GUI extends JFrame 
{
	private ArrayList<Player> players;
	
	public GUI(String title)
	{
		this.players = new ArrayList<Player>();
		
		this.setTitle(title);
		this.setSize(450, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(250, 200);
		
		JPanel panel = buildPanel();
		this.add(panel);
	}
	
	private JPanel buildPanel()
	{
		JPanel mainPanel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		
		JButton crea = new JButton("Crea Players");
		crea.addActionListener((ActionEvent e) -> {
			
			this.players = new ArrayList<Player>();
			
			Lottatore p1 = new Lottatore(100,100,50);
			Lottatore p2 = new Lottatore(100,150,50);
			Lottatore p3 = new Lottatore(100,100,100);
			
			Mago p4 = new Mago(100,50,100);
			Mago p5 = new Mago(100,50,50);
			Mago p6 = new Mago(100,50,150);
			
			LottatoreVolante l1 = new LottatoreVolante(100,200,100);
			LottatoreVolante l2 = new LottatoreVolante(100,100,100);
			
			players.add(p1);
			players.add(p2);
			players.add(p3);
			players.add(p4);
			players.add(p5);
			players.add(p6);

			players.add(l1);
			players.add(l2);
			
			System.out.println("\n\nLista inizializzata e popolata!\n\n");
			
		});
		
		JButton salva = new JButton("Salva Players");
		salva.addActionListener((ActionEvent e) -> {
			
			PrintWriter out = null;
			
			try
			{
				out = new PrintWriter(new BufferedWriter(new FileWriter("players.txt")));
				
				for(Player p : this.players) out.println(p);
				
				out.close();
			}
			catch(EOFException e2)
			{
				out.close();
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				out.close();
			}
			
			System.out.println("\n\nInfo salvate su file!\n\n");
			
		});
		
		JButton simula = new JButton("Combattimento");
		simula.addActionListener((ActionEvent e) -> {
			
			if(this.players.size() == 1) 
				{
					System.out.println("\n\n" + this.players.get(0).getClass().getName() + " vince il torneo!\n\n");
					return;
				}
			
			System.out.println("\n\nSimulazione combattimento tra: ");
			
			Random r = new Random();
			
			Player p1 = this.players.remove(r.nextInt(this.players.size()));
			Player p2 = this.players.remove(r.nextInt(this.players.size()));
			
			System.out.println(p1.getClass().getName() + " e " + p2.getClass().getName() + "\n\n");
			
			for(int i = 0;i < 10; i++)
			{
				if(i%2==0) combattimento(p1,p2);
				else combattimento(p2,p1);
				
				if(p1.getPuntiVita() <= 0)
				{
					System.out.println("Player: " + p2 + " vince!");
					this.players.add(p2);
					return;
				}
				if(p2.getPuntiVita() <= 0)
				{
					System.out.println("Player: " + p1 + " vince!");
					this.players.add(p1);
					return;
				}
			}
			
		});
		
		buttonPanel.add(crea);
		buttonPanel.add(salva);
		buttonPanel.add(simula);
		
		mainPanel.add(buttonPanel);
		
		return mainPanel;
	}
	
	public static void combattimento(Player p1,Player p2)
	{
		System.out.println("\n\nAttacca " + p1.getClass().getName() + "\n\n");
		
		if(p1.attacco(p2)) System.out.println("Attacco Riuscito");
		else System.out.println("Attacco non Riuscito");
		
		p1.potenziamento();
		
		System.out.println("\n\n");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("\n\n");
	}
}
