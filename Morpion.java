
import java.util.Scanner;


class Morpion	{
	public static void main(String[] args) {
		String [][] tableau;
		int nombreCases=5;
		tableau = new String[nombreCases][nombreCases];
		initialiserPlateau(tableau);
		String []colonnes;
		colonnes= new String[nombreCases];
		char lettre = 'A';
		for (int i =0;i<nombreCases;i++){
			colonnes[i] = String.valueOf(lettre);
			lettre+=1;
		}
	//	tableau[0][2]="X";
	//	tableau[1][1]="X";
	//	tableau[2][0]="X";
		int joueur =2;
		boolean gagne = false;
		
		while (gagne == false){
			joueur +=1;
			if (joueur >2){
				joueur=1;
			}
			gagne=jouerUnTourAuJoueur(tableau,colonnes,joueur);
		}
		afficherPlateau(tableau,colonnes);
		System.out.println("the winner is joueur " + joueur  + "!!!");
		
	}
	
	public static boolean jouerUnTourAuJoueur(String[][] tableau, String[] colonnes,int joueur){
		boolean gagne;
		String []lignes;
		lignes=new String[colonnes.length];
		char ligne= '1';
		for (int i =0;i> lignes.length;i++){
			lignes[i]=String.valueOf(ligne);
			ligne+=1;
		}
		afficherPlateau(tableau,colonnes);
		System.out.println("joueur " + joueur + " jouez SVP");
		String typeReponse="colonne";
		int j=saisirReponse(typeReponse,colonnes);
		System.out.println( "==> saisir reponse --> j :" +j);
		typeReponse="ligne";
		int i=saisirReponse(typeReponse,lignes);
		System.out.println( "==> saisir reponse --> i :" +i);
		tableau[i] [j]= "X";
		return verifierSiGagne(tableau);
	}
	
	public static int saisirReponse (String typeReponse,String[] reponsesPossibles){
		
		String entree="";
		int i=-1;
		
		while (entree ==""){
			System.out.println("av saisie : " + entree);
			entree=saisie(typeReponse);
			System.out.println("ap saisie : " + entree);
//			if (entree> reponsesPossibles.length){
//				entree=-1;
//			}
			for (i = 0; i < reponsesPossibles.length;i++){
				System.out.println("boucle : " + i+ " entree " + entree + " table : " + reponsesPossibles[i]);
				if (entree == reponsesPossibles[i]){
					System.out.println("enfintrouve !!!");
					return i;
										
				}
			}
			entree="";
		}
		System.out.println("ko");
		return -1;
	}	
		
	public static String saisie(String typeReponse){
		Scanner sc=new Scanner(System.in);
		String entree="";
		
		while (true){
			System.out.println("Entrez une valeur pour la " + typeReponse + " :");
			entree = sc.next();
//			System.out.println(entree);
			return entree;
		}
		
			
	}
		
		
	
	
	public static void initialiserPlateau(String [][]tableau){
		for (int i=0;i < tableau.length;i++){
			for (int j=0;j<tableau[i].length;j++){
				tableau[i][j] = "0";
			}
		}
	}
	
	public static void afficherPlateau(String [][]tableau,String [] colonnes){
		String ligne= "    ";
		for (int i = 0;i< colonnes.length;i++){
			ligne+=colonnes[i] + "   ";
		}
		System.out.println (ligne);
		for (int i=0;i < tableau.length;i++){
			ligne= i + " ! ";
			for (int j=0;j<tableau[i].length;j++){
				ligne +=tableau[i][j] + " ! ";
			}
			System.out.println(ligne);
		}
	}
	
	public static boolean verifierSiGagne(String [][]tableau){
		
		boolean gagne=verifierSiGagneHorizontal(tableau);
		 
		if (gagne==false){
			gagne=verifierSiGagneVertical(tableau);
		}
		
		if (gagne==false && tableau[0][0]=="X"){
			int depart=0;
			int fin= tableau.length;
			int increment= 1;
			gagne=verifierSiGagneDiagonalGauche(tableau,depart,fin,increment);
		}
		if (gagne==false && tableau[0][tableau[0].length -1]=="X"){
			int depart=tableau.length-1;
			int fin= -1;
			int increment= -1;
			gagne=verifierSiGagneDiagonalGauche(tableau,depart,fin,increment);
		}
		return gagne;
	}
	
	public static boolean verifierSiGagneHorizontal(String [][]tableau){
		boolean gagne = false;
		boolean onStoppe = false;
		int i =0;
		 
		while (onStoppe==false){
			 
			if (tableau [i] [0]== "X"){
				gagne=true;
				for (int j=1;j<tableau[i].length;j++){
					if (tableau [i] [j]== "0"){
						gagne = false;
					}
				}
			}
			onStoppe=gagne;
			i+=1;
			if (i >= tableau.length){
				onStoppe=true;
			}
			
		}
		return gagne;
	}
	
	public static boolean verifierSiGagneVertical(String [][]tableau){
		boolean gagne = false;
		boolean onStoppe = false;
		int j =0;
		 
		while (onStoppe==false){
			 
			if (tableau [0] [j]== "X"){
				gagne=true;
				for (int i=1;i<tableau.length;i++){
					if (tableau [i] [j]== "0"){
						gagne = false;
					}
				}
			}
			onStoppe=gagne;
			j+=1;
			if (j >= tableau[0].length){
				onStoppe=true;
			}
			
		}
		return gagne;
	}
	
	public static boolean verifierSiGagneDiagonalGauche(String [][]tableau,int depart, int fin, int increment){
		boolean gagne = true;
		boolean onStoppe = false;
		int i;
		 
		while (onStoppe==false){
			 					
			for (i=depart;i<fin;i+=increment){
				if (tableau [i] [i]== "0"){
					gagne = false;
				}
			}
			onStoppe=gagne;
			i+=1;
			if (i >= tableau.length){
				onStoppe=true;
			}
		}
		return gagne;
	}
	
}