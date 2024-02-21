package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEstado extends JpaRepository<Estado, String> {
}
