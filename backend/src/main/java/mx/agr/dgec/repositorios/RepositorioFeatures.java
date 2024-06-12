package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Features;
import mx.agr.dgec.enums.MetodosHttpEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RepositorioFeatures extends JpaRepository<Features, Integer> {

    @Query("SELECT DISTINCT r.idRol FROM Features f JOIN f.roles r WHERE f.metodoHttp = :metodoHttp AND f.endpoint = :endpoint")
    Set<String> findIdRolesByMetodoHttpAndEndpoint(@Param("metodoHttp") MetodosHttpEnum metodoHttp, @Param("endpoint") String endpoint);
}
