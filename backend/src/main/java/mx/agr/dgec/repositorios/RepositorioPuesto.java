package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPuesto extends JpaRepository<Puesto, String> {
}
