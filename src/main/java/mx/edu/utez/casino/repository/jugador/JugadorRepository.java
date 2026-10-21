package mx.edu.utez.casino.repository.jugador;

import mx.edu.utez.casino.model.jugador.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
