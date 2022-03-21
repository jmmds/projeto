package br.com.julio.projeto;


import java.util.Arrays;

import java.text.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.julio.projeto.domain.Categoria;
import br.com.julio.projeto.domain.Cidade;
import br.com.julio.projeto.domain.Cliente;
import br.com.julio.projeto.domain.Endereco;
import br.com.julio.projeto.domain.Estado;
import br.com.julio.projeto.domain.Pagamento;
import br.com.julio.projeto.domain.PagamentoBoleto;
import br.com.julio.projeto.domain.PagamentoCartao;
import br.com.julio.projeto.domain.Produto;
import br.com.julio.projeto.domain.Pedido;
import br.com.julio.projeto.domain.enums.EstadoPagamento;
import br.com.julio.projeto.domain.enums.TipoCliente;
import br.com.julio.projeto.repositories.CategoriaRepository;
import br.com.julio.projeto.repositories.CidadeRepository;
import br.com.julio.projeto.repositories.ClienteRepository;
import br.com.julio.projeto.repositories.EnderecoRepository;
import br.com.julio.projeto.repositories.EstadoRepository;
import br.com.julio.projeto.repositories.PagamentoRepository;
import br.com.julio.projeto.repositories.PedidoRepository;
import br.com.julio.projeto.repositories.ProdutoRepository;



@SpringBootApplication
public class ProjetoApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto (null,"Impressora", 800.00);
		Produto p3 = new Produto (null,"Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado (null,"Minas Gerais");
		Estado est2 = new Estado (null,"São Paulo");

		
		

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cidade c1 = new Cidade (null, "Uberlândia", est1);
		Cidade c2 = new Cidade (null,"São Paulo", est2);
		Cidade c3 = new Cidade (null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository. saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cl1 = new Cliente (null, "Kauê Juan Nascimento", "kaue.juan.nascimento@uel.br", "85400726534", TipoCliente.PESSOAFISICA);
		cl1.getTelefone().addAll(Arrays.asList("9535118638", "95999505088"));

		Endereco e1 =new Endereco(null, "Rua 17", "506", "APT 506", "Jardim Floresta", "69312085", cl1, c1);
	
		Endereco e2 =new Endereco(null, "Rua 22", "206", "APT 206", "Floresta", "69312285", cl1, c2);
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido (null, date.parse("18/03/2021 11:32"), cl1, e1 );
		Pedido ped2 = new Pedido (null, date.parse("05/03/2021 11:32"), cl1, e2 );

		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.PEDENTE, ped1, 6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.QUITADO, ped2, date.parse("22/03/2021 00:00"), date.parse("18/03/2021 00:00"));
		ped2.setPagamento(pag2);

		cl1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1,pag2));

		


		
	}

}
