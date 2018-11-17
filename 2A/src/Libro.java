import java.util.ArrayList;
import java.util.Iterator;

public class Libro {
	private String titulo,editor;
	private int paginas,año;
	private ArrayList<String> nombres;

	public Libro() {
	}

	public Libro(String titulo, String editor, int paginas, ArrayList<String> nombres,int año) {
		this.titulo = titulo;
		this.editor = editor;
		this.paginas = paginas;
		this.nombres = nombres;
		this.año=año;
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

	public int getAño() {
		return año;
	}

	@Override
	public String toString() {
		return "Titulo:" + titulo + ",\n Nombre del Autor:"+getNombres()+".\n Editor=" + editor + ".\n Número de Paginas=" + paginas + ".\n Año de Publicación= "+año+".\n";
	}
}
