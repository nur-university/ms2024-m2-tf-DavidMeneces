package bo.nur.sgp_pln.web_api;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.logging.Logger;

@Startup
@ApplicationScoped
public class StartApp {

    @ConfigProperty(name = "quarkus.http.port")
    private int port;

    private static final Logger LOG = Logger.getLogger(StartApp.class.getSimpleName());

    @SuppressWarnings({"Convert2Lambda", "LoggerStringConcat"})
    void onStart(@Observes StartupEvent ev) {
        LOG.info("La Aplicacion esta Iniciando...");
        LOG.info("*********************************************");
        LOG.info("************  APLICACION INICIADA ***********");
        LOG.info("************  URL: http://localhost:" + port + " ***********");
        LOG.info("*********************************************");
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOG.info("La aplicacion se esta deteniendo...");
    }

}

