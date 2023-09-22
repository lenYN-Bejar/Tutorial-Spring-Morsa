package com.codigosonrisa.tutorial;

import com.codigosonrisa.tutorial.models.Libro;
import com.codigosonrisa.tutorial.models.Producto;
import com.codigosonrisa.tutorial.models.UserData;
import com.codigosonrisa.tutorial.myBeans.MiBean;
import com.codigosonrisa.tutorial.myBeans.MiComponente;
import com.codigosonrisa.tutorial.services.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Rutas {

    private IOrderService iorderService;
    private MiBean miBean;
    @Autowired
    private MiComponente miComponente;

    public Rutas(IOrderService iorderService, MiBean miBean) {
        this.iorderService = iorderService;
        this.miBean = miBean;
    }

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/hola")
    String miPrimeraRuta() {
        return "Hola Mundo desde Spring Boot :D :D :D";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial){
        return "El libro que buscas es: " + id + " de la editorial " + editorial;
    }

    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params, @RequestParam String gato){
        return "El libro que buscas es: " + id + " params: " + params + " gato: " + gato;
    }

    @PostMapping("/libro")
    String crearLibro(@RequestBody Libro libro){
        logger.debug("libro {} editorial {}", libro.nombre, libro.editorial);
        return "libro guardado";
    }

    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a una nueva version")
    String miSegundaRutaconStatus() {
        return "Hola Mundo desde Spring Boot :D :D :D con Status";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
        if (lugar.equals("casa")) {
            return ResponseEntity.ok("perro, gato, hamster");
        } else if (lugar.equals("granja")) {
            return ResponseEntity.ok("vaca, cerdo, gallina");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontraron animales");
        }
    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("La clave del usuario es 1234");
    }

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData( ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"nombre\":\"Juan\"}");
    }
    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDataV2() {
        return Map.of("user", Map.of("nombre", "Juan", "age", 34));
    }

    @GetMapping("/userData/v3")
    public UserData getUserDataV3() {
        return new UserData("Juan", 34, "Calle 123");
    }

    @PostMapping("/order")
    public String createOrden(@RequestBody List<Producto> products) {
        iorderService.saveOrder(products);
        return "Productos guardados";
    }

    @GetMapping("/miBean")
    public String saludarDesdeMiBean() {
        miBean.saludar();
        return "Hola desde MiBean";
    }

    @GetMapping("/miComponente")
    public String saludarDesdeMiComponente() {
        miComponente.saludarDesdeComponente();
        return "Hola desde MiComponente";
    }
}


