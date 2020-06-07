import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class API_Cliente {

	private static final String URL = "http://localhost:8080/axis2/services/Calculadora/";
	private static final String error = "Formato: operacion float1 float2";
	private static final String error2 = "Operación non implementada";

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println(error);
			return;
		}

		String operacion = args[0];
		float numero1, numero2 = 0;

		try {
			numero1 = Float.parseFloat(args[1]);
			numero2 = Float.parseFloat(args[2]);
		} catch (Exception e) {
			System.out.println(error);
			return;
		}

		if (!operacion.equals("sumar") && !operacion.equals("restar") && !operacion.equals("multiplicar")
				&& !operacion.equals("dividir")) {
			System.out.println(error2);
			return;
		}

		RPCServiceClient serviceClient = null;
		Object[] response = null;

		try {
			serviceClient = new RPCServiceClient();
		} catch (AxisFault e) {
			e.printStackTrace();
			return;
		}

		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(URL + operacion);

		options.setTo(targetEPR);

		QName opSum = new QName("http://ws.apache.org/axis2", operacion);

		Object[] opSumArgs = new Object[] { numero1, numero2 };
		@SuppressWarnings("rawtypes")
		Class[] returnTypes = new Class[] { Float.class };

		try {
			response = serviceClient.invokeBlocking(opSum, opSumArgs, returnTypes);
		} catch (AxisFault e) {
			e.printStackTrace();
			return;
		}

		Float resultado = (Float) response[0];

		if (resultado == null) {
			System.out.println("Error de conexion");
		} else
			System.out.println("Resultado: " + resultado);

	}

}