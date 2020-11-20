# Semantic_Web

|Generate RDF with Apache Jena|  Application that can change CSV file in to RDF|
|---|---|


Sample generated RDF look like
```

@prefix ex: <http://www.example.com/> . 
@prefix geo: <http://www.w3.org/2003/01/geo/wgs84_pos#> .
@prefix geo: <http://www.w3.org/2003/01/geo/wgs84_pos#> .
@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> . 
@prefix xsd: <http://www.w3.org/2001/XMLSchema#> . 

ex:StopArea:OCE80194035  a  geo:SpatialThing; 
rdfs:label  "gare de Neustadt (Weinstr) Hbf"@fr;
geo:lat  "49.35006155"^^xsd:decimal; 
geo:long "8.14067588"^^xsd:decimal .
