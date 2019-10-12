package ui;

import java.util.Scanner;

import model.AVL;
import model.AVLNode;

public class Main {
	public static void main(String[] args) {
		AVL<Integer, Integer> avl = new AVL<Integer, Integer>();
		Scanner s = new Scanner(System.in);
		int option = s.nextInt();
		while(option != 0) {
			int nodo = s.nextInt();
			switch(option) {
			case 1: //insertar
				avl.add(nodo, nodo);
				break;
			case 2: //eliminar
				avl.delete(nodo);
				break;
			}
			printElements(avl.getRoot());
			option = s.nextInt();
		}
	}

	private static void printElements(AVLNode<Integer, Integer> avn) {
		System.out.println("Nodo: "+avn.getKey()+" ... "+"bf: " + avn.getBalanceFactor() + " ... height: "+avn.getheight() + " Su papa es: "+(avn.getParent()!=null?avn.getParent().getKey():null));
		if(avn.getLeft() != null) {
			printElements(avn.getLeft());
		}
		if(avn.getRight() != null) {
			printElements(avn.getRight());
		}
	}
}
