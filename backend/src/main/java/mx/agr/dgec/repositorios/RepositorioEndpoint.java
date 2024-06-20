package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Endpoint;
import mx.agr.dgec.enums.MetodosHttpEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RepositorioEndpoint extends JpaRepository<Endpoint, Integer> {

    @Query("SELECT DISTINCT r.idRol FROM Endpoint e JOIN e.roles r WHERE e.metodoHttp = :metodoHttp AND e.rutaEndpoint = :rutaEndpoint")
    Set<String> findIdRolesByMetodoHttpAndEndpoint(@Param("metodoHttp") MetodosHttpEnum metodoHttp, @Param("rutaEndpoint") String rutaEndpoint);
}
