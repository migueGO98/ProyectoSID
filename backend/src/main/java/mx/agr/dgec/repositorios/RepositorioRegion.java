package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegion extends JpaRepository<Region, String> {
}
