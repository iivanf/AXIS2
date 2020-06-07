*******TOMCAT-AXIS2********

Nun terminal

Iniciamos tomcat (e asi axis2) con:
./<tomcat_home>/bin/startup.sh

Detemolo con:
./<tomcat_home>/bin/shutdown.sh

********SERVICIO 1*********
Compilamos os java con:
javac -cp "/opt/axis2-1.7.9/lib/*" *.java

Movemos Calculadora.class a <tomcat_home>\webapps\axis2\WEB-INF\pojo

Executamos o cliente deste sevicio con:
java -cp "/opt/axis2-1.7.9/lib/*:" API_Cliente {OPERACION} {FLOAT1} {FLOAT2}

********SERVICIO 2*********
wsdl2java.sh -ss -g -sd -s -u -uri Noticia.wsdl

cambios oportunos no skeleton

javac -cp "/opt/axis2-1.7.9/lib/*" *.java

creamos un directorio tal que
    noticia:
        -noticia (.class)
        -META-INF (services.xml)
        -resources (services.xml, Noticia.wsdl)

Copiamos este directorio en <tomcat_home>/webapps/axis2/WEB-INF/services/

PARA EXECUTAR CLIENTE dende o noso directorio onde se atopa proxecto

java -cp "/opt/axis2-1.7.9/lib/*:.." noticia.ClienteAPI

********SERVICIO 3*********
O Servicio consiste nun conversor de moeda que se conecta a unha API externa coa obtemos o valor da divisa con respecto a outra (https://exchangeratesapi.io/).
Logo facemoslle unha peticion ao noso servicio 1 (Calculadora) para que multiplique o valor dado pola API externa pola cantidade expresada no cliente.

modifcamos o wsdl de Noticia para adecualo ao noso novo Servicio

wsdl2java.sh -ss -g -sd -s -u -uri Conversor.wsdl

modificamos o skeleton e copiamos no lib do axis2 o jar para a lectura dos json.

PARA COMPILAR dende o noso directorio onde se atopa proxecto
javac -cp "/opt/axis2-1.7.9/lib/*:../../lib/*:" *.java

creamos un directorio tal que
    conversor:
        -conversor (.class)
        -META-INF (services.xml)
        -resources (services.xml, Conversor.wsdl)

Copiamos este directorio en <tomcat_home>/webapps/axis2/WEB-INF/services/

PARA EXECUTAR O NOSO CLIENTE dende o noso directorio onde se atopa proxecto

java -cp "/opt/axis2-1.7.9/lib/*:.." conversor.ClienteAPI
