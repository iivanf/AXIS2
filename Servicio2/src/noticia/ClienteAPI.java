package noticia;

import java.util.Scanner;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

/*
 * sendReceive() para los 'getters'
 * sendRobust() para los 'setters'
 */


public class ClienteAPI {
	
	static OMFactory omFactory = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace = omFactory.createOMNamespace("http://Noticia", "nameService1");

	public static void main (String args[]){
				
		ServiceClient Cliente = null;
		
		try {
			Cliente = new ServiceClient();
		} catch (AxisFault e) {
			System.out.println("Error o crear o cliente: " + e.toString());
			System.exit(0);
		}
		
		Options options = new Options();
		
		options.setTo(new EndpointReference("http://localhost:8080/axis2/services/Noticia"));
		options.setAction("urn:Cliente");
		Cliente.setOptions(options);
		
		System.out.println("\t Introduza os comandos secuencialmente");	
		
		while(true){	

			System.out.println("\t1. Cambiar titular");
			System.out.println("\t2. Obter titular");
			System.out.println("\t3. Cambiar descripcion");
			System.out.println("\t4. Obter descripcion");
			System.out.println("\t5. Cambiar URL");
			System.out.println("\t6. Obter URL");
			System.out.println("\t0. Sair do servicio");
						
			int operacion = Integer.parseInt(getOperationRequested(0));
			
			switch (operacion){
			
				case 1: {
					OMElement metodo = omFactory.createOMElement("setTitular", omNameSpace);
					OMElement parametro = omFactory.createOMElement("titular", omNameSpace);
					
					parametro.setText(getOperationRequested(1));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					}
					
					System.out.println("\n\n\t Operacion finalizada.");
					break;
				}
					
				case 2: {
					OMElement metodo = omFactory.createOMElement("getTitular", omNameSpace);
					OMElement respuestaTitular = null;
					
					try {
						respuestaTitular = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					}
					
					System.out.println("\n\n\nTitular: " + respuestaTitular.getFirstElement().getText());
					break;
				}
					
				case 3: {
					OMElement metodo = omFactory.createOMElement("setDescripcion", omNameSpace);
					OMElement parametro = omFactory.createOMElement("descripcion", omNameSpace);
					
					parametro.setText(getOperationRequested(3));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					};
					
					System.out.println("\n\n\nEstableceuse a descripcion correctamente.");
					break;
				}
					
				case 4: {
					OMElement metodo = omFactory.createOMElement("getDescripcion", omNameSpace);
					OMElement respuestaDescripcion = null;
					
					try {
						respuestaDescripcion = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					}

					System.out.println("\n\n\nDescripcion: " + respuestaDescripcion.getFirstElement().getText());
					break;
				}
					
				case 5: {
					OMElement metodo = omFactory.createOMElement("setUrl", omNameSpace);
					OMElement parametro = omFactory.createOMElement("url", omNameSpace);
					
					parametro.setText(getOperationRequested(5));
					metodo.addChild(parametro);
					
					try {
						Cliente.sendRobust(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					}
					
					System.out.println("\n\n\nEstableceuse a URL correctamente.");
					break;
				}
					
				case 6: {
					OMElement metodo = omFactory.createOMElement("getUrl", omNameSpace);
					OMElement respuestaURL = null;
					
					try {
						respuestaURL = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Problema: " + e.toString());
						break;
					}
					
					
					System.out.println("\n\n\nURL: " + respuestaURL.getFirstElement().getText());
					break;
				}
					
				case 0: {
					System.out.println("\nAte a proxima! ;)");
					System.exit(0);
				}
				
				default: {
					System.out.println("\n\t\tIntroduciu unha opcion incorrecta. Por favor, introduza 1, 2, 3, 4, 5, 6 ou 7.\n\n");				
					break;
				}
					
			}
		}
	}
	
	
	/**
	 * M�todo utilizado para obtener qu� operacion desea realizar el usuario. Dicha operaci�n se realizar� a trav�s de la terminal.
	 * @param operationCode C�digo de operaci�n; con �l indicaremos al m�todo qu� tiene que obtener de la terminal
	 * @return Devuelve un entero con la opci�n requerida.
	 */
	@SuppressWarnings("resource")
	public static String getOperationRequested(int operationCode){
		
		switch (operationCode){
		
			case 0: {
				System.out.print("\nPor favor, introduza unha das opcions: ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 1: {
				System.out.print("\nPor favor, introduza o titular da noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 3: {
				System.out.print("\nPor favor, introduza la descripción da noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
		
			case 5: {
				System.out.print("\nPor favor, introduza a URL da noticia:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			default: {
				return null;
			}
		}
	}
}
