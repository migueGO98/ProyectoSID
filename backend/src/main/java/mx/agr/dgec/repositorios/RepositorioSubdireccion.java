package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Subdireccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSubdireccion extends JpaRepository<Subdireccion, String> {
}
