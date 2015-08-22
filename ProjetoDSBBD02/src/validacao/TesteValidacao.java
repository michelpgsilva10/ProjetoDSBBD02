package validacao;

import entidades.Produto;

public class TesteValidacao {

	public static void main(String[] args) {
		Produto p1 = new Produto();
		Exception exc = ValidacaoUtil.valida(p1);
		if (exc != null)
			System.out.println("P1\n" + exc.getMessage());
		
		Produto p2 = new Produto();
		p2.setNome("Produto X");
		exc = ValidacaoUtil.valida(p2);
		if (exc != null)
			System.out.println("P2\n" + exc.getMessage());
		
		Produto p3 = new Produto();
		p3.setNome("Produto Y");
		p3.setEstoque(10);
		exc = ValidacaoUtil.valida(p3);
		if (exc != null)
			System.out.println("P3\n" + exc.getMessage());
		
		System.out.println("Estoque: " + p1.getMargemLucro());
	}
	
}
