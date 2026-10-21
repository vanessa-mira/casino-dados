package mx.edu.utez.casino.service.jugador;

import mx.edu.utez.casino.exception.customException.CustomNotFoundException;
import mx.edu.utez.casino.model.jugador.Jugador;
import mx.edu.utez.casino.model.jugador.dto.RequestCrearJugadorDTO;
import mx.edu.utez.casino.repository.jugador.JugadorRepository;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador crearJugador(RequestCrearJugadorDTO payload) {
        Jugador jugador = new Jugador();
        jugador.setNombre(payload.getNombre());
        jugador.setSaldo(payload.getSaldo());
        jugador.setActivo(true);
        return jugadorRepository.save(jugador);
    }

    // Suma saldo al jugador
    public Jugador recargarSaldo(Long id, Double monto) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("El jugador no existe"));
        jugador.setSaldo(jugador.getSaldo() + monto);
        return jugadorRepository.save(jugador);
    }
}
