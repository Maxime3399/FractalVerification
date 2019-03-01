package fr.Maxime3399.FractalVerification;

import java.util.Scanner;

import fr.Maxime3399.FractalVerification.custom.Chrono;

public class MainClass {
	
	static String version = "v1.0.0";
	
	public static void main(String[]args) {
		
		System.out.println("  ===== Fractal Verification =====\n Version : "+version);
		execute();
		
	}
	
	private static void execute() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(" \n-> Veuillez entrer le nombre d'itérations.");
		
		String str = sc.nextLine();
		
		if(str.equalsIgnoreCase("stop")) {
			
			System.exit(0);
			
		}else {
			
			int it = 0;
			try {
				
				it = Integer.parseInt(str);
				
			}catch (Exception e) {
				
				System.out.println("Vous devez saisir un nombre !");
				execute();
				
			}
			
			Chrono ch = new Chrono();
			ch.start();
			
			String chars[] = null;
			
			System.out.println("[|] Création de la liste de variables...");
			for(int i = 0; i < it; i++) {
				
				System.out.println("# Iteration -> "+i);
				
				if(i == 0) {
					
					chars = "A".split(",");
					
				}else{
					
					String cts = "";
					
					for(String c : chars) {
						
						cts = cts+c;
							
					}
					
					cts = cts.replaceAll("A", ",A,B,A,C,A,B,A,");
					
					chars = cts.replaceFirst(",", "").split(",");
					
				}
				
			}
			
			System.out.println("[|] Affichage en cours...");
			int cc = 0;
			if(chars != null) {
				cc = chars.length;
			}
			
			System.out.println("Taille de la liste : "+cc);
			if(cc > 999) {
				System.out.println("La liste est trop longue pour être affichée dans la console !");
			}else if(chars != null){
				String cts = "";
				
				for(String c : chars) {
						
					cts = cts+" | "+c;
						
				}
				System.out.println("Liste : "+cts);
			}else {
				System.out.println("Il n'y a aucuns éléments dans la liste.");
			}
			ch.stop();
			System.out.println("Durée de l'oppération : "+ch.getDureeSec()+" s "+ch.getDureeMs()+" ms");
			execute();
			
		}
		
	}

}
