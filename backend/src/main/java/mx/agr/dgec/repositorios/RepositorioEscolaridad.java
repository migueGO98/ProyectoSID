package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Escolaridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEscolaridad extends JpaRepository<Escolaridad, String> {
}
