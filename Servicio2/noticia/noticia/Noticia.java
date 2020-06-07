/**
 * Noticia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;


/*
 *  Noticia java interface
 */
public interface Noticia {
    /**
     * Auto generated method signature
     *
     * @param getTitular45
     */
    public noticia.GetTitularResponse getTitular(
        noticia.GetTitular getTitular45) throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     */
    public void setTitular(noticia.SetTitular setTitular47)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     */
    public void setDescripcion(noticia.SetDescripcion setDescripcion48)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param getDescripcion49
     */
    public noticia.GetDescripcionResponse getDescripcion(
        noticia.GetDescripcion getDescripcion49)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param getUrl51
     */
    public noticia.GetUrlResponse getUrl(noticia.GetUrl getUrl51)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     *
     */
    public void setUrl(noticia.SetUrl setUrl53) throws java.rmi.RemoteException;

    //
}
