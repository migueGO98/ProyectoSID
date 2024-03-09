package mx.agr.dgec.repositorios;

import mx.agr.dgec.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, String> {
}
