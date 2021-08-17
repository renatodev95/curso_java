package generics;

public class CaixaObjetoTeste {

	public static void main(String[] args) {
		
		// 244. Exemplo B�sico SEM Generics
		
		CaixaObjeto caixaA = new CaixaObjeto();
		caixaA.guardar(2.3); // double -> Double
		
		Double coisaA = (Double) caixaA.abrir();
		System.out.println(coisaA);
		
		CaixaObjeto caixaB = new CaixaObjeto();
		caixaA.guardar("Ol� mundo");
		
		String coisaB = (String) caixaB.abrir();
		System.out.println(coisaB);
	}
}
