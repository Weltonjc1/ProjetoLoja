package br.com.loja.jdbc.dao;

import br.com.loja.entidades.Produto;

public class TestaInsereProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			//pronto para gravar
			Produto produto = new Produto();
			produto.setProdutoDescricao("PELICULA J120 P1-01");
			produto.setProdutoEstoque(6);
			produto.setProdutoEstoqueMinimo(2);
			produto.setProdutoPrecoCusto(0.8);
			produto.setProdutoPrecoVenda(10.30);
			
			//grave nesta conexao
			ProdutoDao dao = new ProdutoDao();
			
			//metodo elegante
			dao.adiciona(produto);
			
			System.out.println("Gravado");
			
	}

}
