package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, String> {
}
