package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, String> {
}
