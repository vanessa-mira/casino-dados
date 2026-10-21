package mx.edu.utez.casino.controller.jugador;

import jakarta.validation.Valid;
import mx.edu.utez.casino.model.jugador.Jugador;
import mx.edu.utez.casino.model.jugador.dto.RequestCrearJugadorDTO;
import mx.edu.utez.casino.model.jugador.dto.RequestRecargarSaldoDTO;
import mx.edu.utez.casino.service.jugador.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugador")
@CrossOrigin({"*"})
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody @Valid RequestCrearJugadorDTO payload) {
        return ResponseEntity.status(201).body(jugadorService.crearJugador(payload));
    }

    @PutMapping("/{id}/recargar")
    public ResponseEntity<Jugador> recargarSaldo(@PathVariable Long id,
                                                 @RequestBody @Valid RequestRecargarSaldoDTO payload) {
        return ResponseEntity.status(200).body(jugadorService.recargarSaldo(id, payload.getMonto()));
    }
}
