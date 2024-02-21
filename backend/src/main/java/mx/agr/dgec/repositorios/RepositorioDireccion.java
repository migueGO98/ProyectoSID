package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDireccion extends JpaRepository<Direccion, String> {
}
