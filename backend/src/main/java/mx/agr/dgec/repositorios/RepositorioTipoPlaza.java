package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.TipoPlaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoPlaza extends JpaRepository<TipoPlaza, String> {
}
