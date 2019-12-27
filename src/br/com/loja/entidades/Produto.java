package br.com.loja.entidades;

import java.util.Calendar;

public class Produto {

	private int produtoCodigo;
	private String produtoDescricao;
	private int produtoEstoque;
	private int produtoEstoqueMinimo;
	private double produtoPrecoCusto;
	private double produtoDesconto;
	private double produtoPrecoVenda;
        private int produtoCodigoBarra;
        private Calendar produtoData;

    public Calendar getProdutoData() {
        return produtoData;
    }

    public void setProdutoData(Calendar produtoData) {
        this.produtoData = produtoData;
    }
        
	public int getProdutoCodigo() {
		return produtoCodigo;
	}
	public void setProdutoCodigo(int produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}
	public String getProdutoDescricao() {
		return produtoDescricao;
	}
	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}
	public int getProdutoEstoque() {
		return produtoEstoque;
	}
	public void setProdutoEstoque(int produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}
	public int getProdutoEstoqueMinimo() {
		return produtoEstoqueMinimo;
	}
	public void setProdutoEstoqueMinimo(int produtoEstoqueMinimo) {
		this.produtoEstoqueMinimo = produtoEstoqueMinimo;
	}
	public double getProdutoPrecoCusto() {
		return produtoPrecoCusto;
	}
	public void setProdutoPrecoCusto(double produtoPrecoCusto) {
		this.produtoPrecoCusto = produtoPrecoCusto;
	}
	public double getProdutoDesconto() {
		return produtoDesconto;
	}
	public void setProdutoDesconto(double produtoDesconto) {
		this.produtoDesconto = produtoDesconto;
	}
	public double getProdutoPrecoVenda() {
		return produtoPrecoVenda;
	}
	public void setProdutoPrecoVenda(double produtoPrecoVenda) {
		this.produtoPrecoVenda = produtoPrecoVenda;
	}
        public int getProdutoCodigoBarra(){
            return produtoCodigoBarra;
        }
        public void setProdutoCodigoBarra(int produtoCodigoBarra){
            this.produtoCodigoBarra = produtoCodigoBarra;
        }
}
