package mx.edu.utez.casino.repository.partida;

import mx.edu.utez.casino.model.partida.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findByJugadorId(Long jugadorId);
}
