import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class PdfConverter {

    public static void main(String[] args){


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("C:\\Projetos/Pessoas.xml");

            NodeList listaDePessoas = doc.getElementsByTagName("pessoa");

            int tamanhoLista = listaDePessoas.getLength();

            for(int i = 0; i < tamanhoLista; i++){

                Node noPessoa = listaDePessoas.item(i);

                if(noPessoa.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element elementoPessoa = (Element) noPessoa;

                    String id = elementoPessoa.getAttribute("id");

                    System.out.println("ID = " + id);

                }

            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PdfConverter.class.getName()).log(Level.SEVERE,null, ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

}


