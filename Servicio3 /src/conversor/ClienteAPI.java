package conversor;

import java.util.Scanner;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class ClienteAPI {
	
	static OMFactory omFactory = OMAbstractFactory.getOMFactory();
	static OMNamespace omNameSpace = omFactory.createOMNamespace("http://Conversor", "nameService1");

	public static void main (String args[]){
				
		ServiceClient Cliente = null;
		
		try {
			Cliente = new ServiceClient();
		} catch (AxisFault e) {
			System.out.println("Error o crear o cliente: " + e.toString());
			System.exit(0);
		}
		
		Options options = new Options();
		
		options.setTo(new EndpointReference("http://localhost:8080/axis2/services/Conversor"));
		options.setAction("urn:getConversion");
		Cliente.setOptions(options);
		
		System.out.println("\t Introduza os comandos secuencialmente");	
		
		while(true){	

			System.out.println("\t1. Cambiar divisa");
			System.out.println("\t0. Sair do servizo");
						
			int operacion = Integer.parseInt(getOperationRequested(0));
			
			switch (operacion){
			
				case 1: {
					OMElement metodo = omFactory.createOMElement("getConversor", omNameSpace);
					OMElement args0 = omFactory.createOMElement("args0", omNameSpace);
                    OMElement args1 = omFactory.createOMElement("args1", omNameSpace);
                    OMElement args2 = omFactory.createOMElement("args2", omNameSpace);
					OMElement respuestaConversor = null;
					
					args0.setText(getOperationRequested(1));
					metodo.addChild(args0);
                    args1.setText(getOperationRequested(2));
					metodo.addChild(args1);
                    args2.setText(getOperationRequested(3));
					metodo.addChild(args2);
					
					try {
					    respuestaConversor = Cliente.sendReceive(metodo);
					} catch (AxisFault e) {
						System.out.println("Erro: " + e.toString());
						break;
					}
					
					System.out.println("\n\n\t Resposta: "+respuestaConversor.getFirstElement().getText()+"\n\n");
					break;
				}
					
				case 0: {
					System.out.println("\n\tAta a proxima! ;)");
					System.exit(0);
				}
				
				default: {
					System.out.println("\n\t\tIntoduciu unha opción incorrecta. Por favor, introduza 1, 2, 3, 4, 5, 6 ou 7.\n\n");				
					break;
				}
					
			}
		}
	}
	

	@SuppressWarnings("resource")
	public static String getOperationRequested(int operationCode){
		
		switch (operationCode){
		
			case 0: {
				System.out.print("\nPor favor, introduza unha das opcions: ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 1: {
				System.out.print("\nPor favor, introduza a divisa que desexa cambiar ('EUR'):\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			case 2: {
				System.out.print("\nPor favor, introduza a cantidade que desexa cambiar:\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
		
			case 3: {
				System.out.print("\nPor favor, introduza a divisa a que desexa cambiar ('USD'):\n\t-> ");
				Scanner entradaTerminal = new Scanner(System.in);
				return entradaTerminal.nextLine();
			}
			
			default: {
				return null;
			}
		}
	}
}
