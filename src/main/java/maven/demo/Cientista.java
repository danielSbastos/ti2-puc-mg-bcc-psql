package maven.demo;

public class Cientista {
	private int codigo;
	private String nome;
	private String area;
	private String contribuicao;
	private String nacionalidade;

	public Cientista(int codigo, String nome, String area, String contribuicao, String nacionalidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.area = area;
		this.contribuicao = contribuicao;
		this.nacionalidade = nacionalidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getArea() {
		return area;
	}

	public String getContribuicao() {
		return contribuicao;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setContribuicao(String contribuicao) {
		this.contribuicao = contribuicao;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	@Override
	public String toString() {
		return "[Cientista [codigo=" + codigo + ", nome=" + nome + ", area=" + area + ", contribuicao=" + contribuicao + ", nacionalidade=" + nacionalidade + "]";
	}
}
