import java.util.ArrayList;
import java.util.Iterator;

public class Libro {
	private String titulo,editor;
	private int paginas,a�o;
	private ArrayList<String> nombres;

	public Libro() {
	}

	public Libro(String titulo, String editor, int paginas, ArrayList<String> nombres,int a�o) {
		this.titulo = titulo;
		this.editor = editor;
		this.paginas = paginas;
		this.nombres = nombres;
		this.a�o=a�o;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditor() {
		return editor;
	}

	public int getpaginas() {
		return paginas;
	}

	public String getNombres() {
		Iterator it=nombres.iterator();
		String result="";
		int x=0;
		while(it.hasNext()) {
			String temp=(String) it.next();
			result=result+" "+temp+"";
			x++;
		}
		return result;
	}

	public int getA�o() {
		return a�o;
	}

	@Override
	public String toString() {
		return "Titulo:" + titulo + ",\n Nombre del Autor:"+getNombres()+".\n Editor=" + editor + ".\n N�mero de Paginas=" + paginas + ".\n A�o de Publicaci�n= "+a�o+".\n";
	}
}
