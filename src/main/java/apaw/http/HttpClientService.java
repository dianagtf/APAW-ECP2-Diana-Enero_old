package apaw.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpClientService {

    public HttpResponse httpRequest(HttpRequest request) {
        Logger logger = LogManager.getLogger(this.getClass().getName());
        logger.info(request.toString());
        HttpResponse response = new Server().submit(request);
        logger.info(response);
        logger.info("---------------------------------------ooo----------------------------------------");
        if (response.getStatus().isError()) {//La respuesta (excepción) la monto en el cliente
            throw new HttpException(response.getStatus().toString());
        }
        return response;
    }
}
