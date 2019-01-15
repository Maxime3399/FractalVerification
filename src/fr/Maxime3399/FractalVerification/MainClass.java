package fr.Maxime3399.FractalVerification;

import java.util.Scanner;

public class MainClass {
	
	static String version = "v1.0.0-a1.0";
	
	public static void main(String[]args) {
		
		System.out.println("  ===== Fractal Verification =====\n Version : "+version+"\n ");
		execute();
		
	}
	
	private static void execute() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nombre d'itérations.");
		
		String str = sc.nextLine();
		
		if(str.equalsIgnoreCase("stop")) {
			
			System.exit(0);
			
		}else {
			
			try {
				
				int it = Integer.parseInt(str);
				String chars[] = "A,B,A,C,C,A,B,A".split(",");
				
				for(int i = 1; i < it; i++) {
					
					String cts = "";
						
					for(String c : chars) {
							
						cts = cts+c;
							
					}
					
					cts = cts.replaceAll("A", ",A,B,A,C,C,A,B,A,").replaceAll("CC", "C,C");
					chars = cts.replaceFirst(",", "").split(",");
					
				}
				
				String cts = "";
				
				for(String c : chars) {
						
					cts = cts+" | "+c;
						
				}
				
				System.out.println("Taille de la liste : "+chars.length);
				if(chars.length > 999) {
					System.out.println("La liste est trop longue pour être affichée dans le console !");
				}else {
					System.out.println("Liste : "+cts);
				}
				execute();
				
			}catch (Exception e) {
				
				System.out.println("Vous devez saisir un nombre !");
				execute();
				
			}
			
		}
		
	}

}
