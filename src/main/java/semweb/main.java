package semweb;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class main {
	public static void main(String[] args) {
		
	Model model= ModelFactory.createDefaultModel();
	//	Resource resource1 = model.createResource("http:example.org/this");
	//	Property prop = model.createProperty("http://myprop.com/");
	//	Resource resource2 = model.createResource("http:example.org/that");
		//model.add(resource1,prop,resource2);
		//model.write(System.out,"Turtle");
	//}
//}


	
String ex = "http://www.example.com/StopArea:";
String exThingURI = "http://www.example.com/StopArea:SpatialThing";
String geo = "https://www.w3.org/2003/01/geo/wgs84_pos#";
String xsd = "http://www.w3.org/2000/01/rdf-schema/";
//private Model model;



Resource SpatialThing = model.createResource(exThingURI); 
Property geoLat = model.createProperty(geo + "lat");
Property geoLong = model.createProperty(geo + "long");	
File file = new File("C:\\Users\\cps2M1\\Downloads\\downloads\\stops.txt"); 
{
	try {
	BufferedReader br = new BufferedReader(new FileReader(file)); 

	

    String line = null;
	while ((line = br.readLine()) != null) {
	  String[] data = line.split(",");
	  
	  Resource Dataset = model.createResource(ex + data[0].replaceAll(" ", "_"));
	  Dataset.addProperty(RDF.type, SpatialThing);
	  Dataset.addProperty(RDFS.label, data[1], "Fr");
	  Dataset.addProperty(geoLat, data[3], XSDDatatype.XSDdecimal);
	  Dataset.addProperty(geoLong, data[4], XSDDatatype.XSDdecimal);
	}
    br.close();
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}



model.write(System.out, "turtle");
 
}
String datasetURL = "http://localhost:3030/test";
String sparqlEndpoint = datasetURL + "/sparql";
String sparqlUpdate = datasetURL + "/update";
String graphStore = datasetURL + "/data";
RDFConnection conneg = RDFConnectionFactory.connect(sparqlEndpoint,sparqlUpdate,graphStore);
conneg.load(model); // add the content of model to the triplestore
}
}
