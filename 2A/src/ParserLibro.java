
public class ParserLibro {

	public static void main(String[] args) {
		
		Parser parser=new Parser();
		parser.parseFicheroXml("biblioteca.xml");
		parser.parseDocument();
		parser.print();

	}

}
