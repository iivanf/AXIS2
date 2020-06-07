/**
 * NoticiaSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;

/**
 *  NoticiaSkeleton java skeleton for the axisService
 */
public class NoticiaSkeleton {
   private static String titular =  "Titular default";
    private static String url = "urldefault.test";
    private static String descipcion = "descripcion default";
    /**
     * Auto generated method signature
     *
     * @param getTitular
     * @return getTitularResponse
     */
    public noticia.GetTitularResponse getTitular(noticia.GetTitular getTitular) {
        //TODO : fill this with the necessary business logic
        noticia.GetTitularResponse titular = new noticia.GetTitularResponse();
        titular.set_return(NoticiaSkeleton.titular);
        return titular;
/*         throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getTitular"); */
    }

    /**
     * Auto generated method signature
     *
     * @param setTitular
     * @return
     */
    public void setTitular(noticia.SetTitular setTitular) {
        //TODO : fill this with the necessary business logic
        titular = setTitular.getTitular();
    }

    /**
     * Auto generated method signature
     *
     * @param setDescripcion
     * @return
     */
    public void setDescripcion(noticia.SetDescripcion setDescripcion) {
        //TODO : fill this with the necessary business logic
        descipcion = setDescripcion.getDescripcion();
    }

    /**
     * Auto generated method signature
     *
     * @param getDescripcion
     * @return getDescripcionResponse
     */
    public noticia.GetDescripcionResponse getDescripcion(
        noticia.GetDescripcion getDescripcion) {
        //TODO : fill this with the necessary business logic
        noticia.GetDescripcionResponse descripcion = new noticia.GetDescripcionResponse();
        descripcion.set_return(NoticiaSkeleton.descipcion);
        return descripcion;
/*         throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getDescripcion"); */
    }

    /**
     * Auto generated method signature
     *
     * @param getUrl
     * @return getUrlResponse
     */
    public noticia.GetUrlResponse getUrl(noticia.GetUrl getUrl) {
        //TODO : fill this with the necessary business logic
        noticia.GetUrlResponse url = new noticia.GetUrlResponse();
        url.set_return(NoticiaSkeleton.url);
        return url;
/*         throw new java.lang.UnsupportedOperationException("Please implement " +
            this.getClass().getName() + "#getUrl"); */
    }

    /**
     * Auto generated method signature
     *
     * @param setUrl
     * @return
     */
    public void setUrl(noticia.SetUrl setUrl) {
        //TODO : fill this with the necessary business logic
        url = setUrl.getUrl();
    }
}
