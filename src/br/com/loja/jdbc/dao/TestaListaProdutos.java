/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.jdbc.dao;

import br.com.loja.entidades.Produto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TestaListaProdutos {
    public static void main(String[] args) {
        
        ProdutoDao pdao = new ProdutoDao();
        String pesq = "PELIC";
        List<Produto> produtos = pdao.getListaFiltroDescricao(pesq);
        
        try {
            FileWriter arq = new FileWriter("d:\\relatorio.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
       
            gravarArq.println("-----------------------------------------------------------------");
            gravarArq.println("                   Relatorio Estoque Custo-Venda");
            gravarArq.println("-----------------------------------------------------------------");
            gravarArq.println("  CODIGO  -  ESTOQUE -  CUSTO  -  VENDA  -  DESCRICAO  - TOTAL    ");
             double contador = 0; 
            for(Produto produto : produtos){
            
            gravarArq.printf("     "+produto.getProdutoCodigo());
            gravarArq.printf("           "+produto.getProdutoEstoque());
            gravarArq.printf("      "+produto.getProdutoPrecoCusto());
            gravarArq.printf("      "+produto.getProdutoPrecoVenda());
            gravarArq.printf("       "+produto.getProdutoPrecoVenda() * produto.getProdutoEstoque());
            gravarArq.println("      "+produto.getProdutoDescricao());
            double somas = produto.getProdutoPrecoVenda() * produto.getProdutoEstoque();
            }
            
            gravarArq.println("TOTAL PATRIMONIO VENDAS = "+contador);
            
        arq.close();
        gravarArq.close();
            System.out.println("Gerado arquivo com sucesso!!");
         } catch (IOException ex) {
            Logger.getLogger(TestaListaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    } 

