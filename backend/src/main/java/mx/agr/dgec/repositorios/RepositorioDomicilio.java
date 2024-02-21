package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDomicilio extends JpaRepository<Domicilio, String> {
}
