package aula10;

import java.util.ArrayList;
import java.util.List;

public class Controle {
	
	private List<Produto> produtosComEstoqueInsuficiente;
	private List<Produto> produtosComEstoqueExcedente;
	private List<Produto> produtosComEstoqueZerado;
	private List<Produto> produtosComEstoqueAdequado;


	public List<Produto> getProdutosComEstoqueInsuficiente() {
		return produtosComEstoqueInsuficiente;
	}


	public List<Produto> getProdutosComEstoqueExcedente() {
		return produtosComEstoqueExcedente;
	}


	public List<Produto> getProdutosComEstoqueZerado() {
		return produtosComEstoqueZerado;
	}


	public List<Produto> getProdutosComEstoqueAdequado() {
		return produtosComEstoqueAdequado;
	}


	public void controlaEstoques(Estoque estoque) {
		int count = 0;
		
		produtosComEstoqueInsuficiente = new ArrayList<Produto>();
		produtosComEstoqueExcedente = new ArrayList<Produto>();
		produtosComEstoqueZerado = new ArrayList<Produto>();
		produtosComEstoqueAdequado = new ArrayList<Produto>();
		
		for(Produto produto : estoque.getProdutos()) {
			if(produto.getEstoqueMinimo() > produto.getQuantidade())
				produtosComEstoqueInsuficiente.add(produto);
			
			if(produto.getEstoqueMaximo() < produto.getQuantidade())
				produtosComEstoqueExcedente.add(produto);
			
			
			if(produto.getQuantidade() == 0)
				produtosComEstoqueZerado.add(produto);
			
			if(produto.getEstoqueMinimo() < produto.getQuantidade() && produto.getEstoqueMaximo() > produto.getQuantidade())
				produtosComEstoqueAdequado.add(produto);
			
			count ++;
		}
		
		if(produtosComEstoqueZerado.size() == count || produtosComEstoqueZerado.size() == 0) {
			produtosComEstoqueInsuficiente.clear();
			produtosComEstoqueExcedente.clear();
			produtosComEstoqueZerado.clear();
			produtosComEstoqueAdequado.clear();
		}
		
	}

}
