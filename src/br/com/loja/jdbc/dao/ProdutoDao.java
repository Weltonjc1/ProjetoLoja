package br.com.loja.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.loja.entidades.Produto;
import br.com.loja.jdbc.ConnectionFactory;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDao {
	//a conexao com o banco
	private Connection connection;
	
	
	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona (Produto produto) {
		String sql ="insert into produtos"+
					"\r\n" + 
					"(produto_descricao,produto_estoque,produto_estoque_minimo,produto_preco_custo,produto_desconto,produto_preco_venda,produto_data)"+
				"values (?,?,?,?,?,?,?)";
		try {
			//prepared statment para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta valores
			stmt.setString(1, produto.getProdutoDescricao());
			stmt.setInt(2, produto.getProdutoEstoque());
			stmt.setInt(3, produto.getProdutoEstoqueMinimo());
			stmt.setDouble(4, produto.getProdutoPrecoCusto());
			stmt.setDouble(5, produto.getProdutoDesconto());
			stmt.setDouble(6, produto.getProdutoPrecoVenda());
			stmt.setDate(7, new Date(produto.getProdutoData().getTimeInMillis()));
			//executa
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		}catch(SQLException e) {
                        JOptionPane.showMessageDialog(null, "erro ao salvar");
			throw new RuntimeException();
		}
	}
        
        public List<Produto> getLista(){
            ResultSet rs = null;
            PreparedStatement stmt = null;
            try {
                List<Produto> produtos = new ArrayList<Produto>();
                stmt = connection.prepareStatement("SELECT * FROM Produtos");
                 
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    //criando o objeto produtos
                    Produto p = new Produto();
                    p.setProdutoCodigo(rs.getInt("produto_codigo"));
                    p.setProdutoCodigoBarra(rs.getInt("produto_codigo_barra"));
                    p.setProdutoDescricao(rs.getString("produto_descricao"));
                    p.setProdutoEstoque(rs.getInt("produto_estoque"));
                    p.setProdutoEstoqueMinimo(rs.getInt("produto_estoque_minimo"));
                    p.setProdutoPrecoCusto(rs.getDouble("produto_preco_custo"));
                    p.setProdutoDesconto(rs.getDouble("produto_desconto"));
                    p.setProdutoPrecoVenda(rs.getDouble("produto_preco_venda"));
                    //montando a data atraves do Calendar
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("produto_data"));
                    p.setProdutoData(data);
                    
//adicionando o objeto a lista
                    produtos.add(p);
                }
                rs.close();
                stmt.close();
                return produtos;
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
                
            
        }

        public List<Produto> getListaFiltroCodigo(int Codigo){
            ResultSet rs = null;
            PreparedStatement stmt = null;
            try {
                List<Produto> produtos = new ArrayList<Produto>();
                stmt = connection.prepareStatement("SELECT * FROM Produtos WHERE produto_codigo = ?");
                stmt.setInt(1, Codigo);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    //criando o objeto produtos
                    Produto p = new Produto();
                    p.setProdutoCodigo(rs.getInt("produto_codigo"));
                    p.setProdutoCodigoBarra(rs.getInt("produto_codigo_barra"));
                    p.setProdutoDescricao(rs.getString("produto_descricao"));
                    p.setProdutoEstoque(rs.getInt("produto_estoque"));
                    p.setProdutoEstoqueMinimo(rs.getInt("produto_estoque_minimo"));
                    p.setProdutoPrecoCusto(rs.getDouble("produto_preco_custo"));
                    p.setProdutoDesconto(rs.getDouble("produto_desconto"));
                    p.setProdutoPrecoVenda(rs.getDouble("produto_preco_venda"));
                    
                    //montando a data atraves do Calendar
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("produto_data"));
                    p.setProdutoData(data);
                    
                    //adicionando o objeto a lista
                    produtos.add(p);
                }
                rs.close();
                stmt.close();
                return produtos;
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
                
            
        }

        public List<Produto> getListaFiltroDescricao(String descricao){
            ResultSet rs = null;
            PreparedStatement stmt = null;
            try {
                List<Produto> produtos = new ArrayList<>();
                stmt = connection.prepareStatement("SELECT * FROM Produtos WHERE produto_descricao LIKE ? ");
                stmt.setString(1,  '%'+descricao+'%');
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    //criando o objeto produtos
                    Produto p = new Produto();
                    p.setProdutoCodigo(rs.getInt("produto_codigo"));
                    p.setProdutoCodigoBarra(rs.getInt("produto_codigo_barra"));
                    p.setProdutoDescricao(rs.getString("produto_descricao"));
                    p.setProdutoEstoque(rs.getInt("produto_estoque"));
                    p.setProdutoEstoqueMinimo(rs.getInt("produto_estoque_minimo"));
                    p.setProdutoPrecoCusto(rs.getDouble("produto_preco_custo"));
                    p.setProdutoDesconto(rs.getDouble("produto_desconto"));
                    p.setProdutoPrecoVenda(rs.getDouble("produto_preco_venda"));
                    //montando a data atraves do Calendar
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("produto_data"));
                    p.setProdutoData(data);
                    
                    //adicionando o objeto a lista
                    produtos.add(p);
                }
                rs.close();
                stmt.close();
                return produtos;
                
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
                
            
        }

        
        public void alteraProduto(Produto p){
            String sql =   "update produtos set produto_descricao=?, produto_estoque=?, produto_estoque_minimo=?, produto_preco_cuto=?, produto_desconto=?, produto_preco_venda=?, produto_codigo_barra=?, produto_data=? where produto_codigo=?";
         
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, p.getProdutoDescricao());
                stmt.setInt(2, p.getProdutoEstoque());
                stmt.setInt(3, p.getProdutoEstoqueMinimo());
                stmt.setDouble(4, p.getProdutoPrecoCusto());
                stmt.setDouble(5, p.getProdutoDesconto());
                stmt.setDouble(6, p.getProdutoPrecoVenda());
                stmt.setInt(7, p.getProdutoCodigoBarra());
                stmt.setDate(8, new Date (p.getProdutoData().getTimeInMillis()));
                stmt.setInt(9, p.getProdutoCodigo());
                stmt.execute();
                stmt.close();
                     
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

        public void removeProduto(Produto p){
            try {
                PreparedStatement stmt = connection.prepareStatement("delete from produtos where produto_codigo=?");
                stmt.setInt(1, p.getProdutoCodigo());
                stmt.execute();
                stmt.close();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
