package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFeatures extends JpaRepository<Features, Integer> {
}
