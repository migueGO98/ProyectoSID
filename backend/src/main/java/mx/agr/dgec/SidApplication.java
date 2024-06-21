package mx.agr.dgec;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mx.agr.dgec.entidades.*;
import mx.agr.dgec.enums.*;
import mx.agr.dgec.repositorios.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase principal de la aplicación.
 *
 * @Author Miguel Guzman
 * @Date 2023-10-17
 * @implNote Este proyecto solo se usa con fines de aprendizaje. No se debe usar
 * para fines de producción o comercialización.
 * @version 1.0.0-SNAPSHOT
 * @since 1.0.0-SNAPSHOT
 */
@SpringBootApplication
@RequiredArgsConstructor
public class SidApplication {

	private final RepositorioRol repositorioRol;
	private final RepositorioEmpleado repositorioEmpleado;
	private final RepositorioRegion repositorioRegion;
	private final RepositorioEstado repositorioEstado;
	private final RepositorioDireccion repositorioDireccion;
	private final RepositorioSubdireccion repositorioSubdireccion;
	private final RepositorioTipoPlaza repositorioTipoPlaza;
	private final RepositorioPuesto repositorioPuesto;
	private final RepositorioEndpoint repositorioEndpoint;



	public static void main(String[] args) {
		SpringApplication.run(SidApplication.class, args);
	}


	@PostConstruct
	public void init() {
		agregarRegiones();
		agregarTiposPlaza();
		agregarRoles();
		agregarEndpoints();
		agregarPuestos();
		agregarEstados();
		agregarDirecciones();
		agregarSubdirecciones();
		agregarEmpleado();
	}


	public void agregarTiposPlaza() {
		var tiposPlazas = Stream.of(
				TipoPlaza.builder().idTipoPlaza("SPC").nombre("Servicio Profesional de Carrera"),
				TipoPlaza.builder().idTipoPlaza("INCA").nombre("Personal del Instituto Nacional de Carrera"),
				TipoPlaza.builder().idTipoPlaza("EE").nombre("Estructura Eventual")
		)
				.map(TipoPlaza.TipoPlazaBuilder::build)
				.toList();
		repositorioTipoPlaza.saveAll(tiposPlazas);
	}

	public void agregarPuestos() {
		var plazaSPC = TipoPlaza.builder().idTipoPlaza("SPC").nombre("Servicio Profesional de Carrera").build();
		var plazaINCA = TipoPlaza.builder().idTipoPlaza("INCA").nombre("Personal del Instituto Nacional de Carrera").build();
		var plazaEE = TipoPlaza.builder().idTipoPlaza("EE").nombre("Estructura Eventual").build();
		var puestos = Stream.of(
						Puesto.builder().idPuesto("NA1").nombre("Director General").tipoPlaza(plazaSPC).salarioBruto(55459.67f),
						Puesto.builder().idPuesto("HEANR").nombre("Homólogo de Enlace de Alto Nivel de Responsabilidad").tipoPlaza(plazaEE).salarioBruto(22478.15f),
						Puesto.builder().idPuesto("SJD1").nombre("Subjefe de Departamento 1").tipoPlaza(plazaINCA).salarioBruto(15478.49f)
					)
					.map(Puesto.PuestoBuilder::build)
					.toList();
		repositorioPuesto.saveAll(puestos);
	}

	public void agregarRoles() {
		var roles = Stream.of(
						Rol.builder().idRol("ADMIN").descripcion("Administrador"),
						Rol.builder().idRol("RH1").descripcion("Recursos Humanos Nivel 1"),
						Rol.builder().idRol("RH2").descripcion("Recursos Humanos Nivel 2"),
						Rol.builder().idRol("RH3").descripcion("Recursos Humanos Nivel 3")
				)
				.map(Rol.RolBuilder::build)
				.collect(Collectors.toSet());
		repositorioRol.saveAll(roles);
	}

	public void agregarEndpoints() {
		var listaRoles = Stream.of(Rol.builder().idRol("ADMIN").descripcion("Administrador").build(),
				Rol.builder().idRol("RH1").descripcion("Recursos Humanos Nivel 1").build())
				.collect(Collectors.toSet());

		var rolRh2 = Rol.builder().idRol("RH2").descripcion("Recursos Humanos Nivel 2").build();
		var endpoints = Stream.of(
						Endpoint.builder().metodoHttp(MetodosHttpEnum.GET).rutaEndpoint("/api/empleados").description("Obtener todos los empleados").roles(listaRoles),
						Endpoint.builder().metodoHttp(MetodosHttpEnum.POST).rutaEndpoint("/api/empleados").description("Crear un empleado").roles(listaRoles),
						Endpoint.builder().metodoHttp(MetodosHttpEnum.GET).rutaEndpoint("/api/motivos-baja").description("Obtener los motivos de baja").roles(Set.of(rolRh2))
				)
				.map(Endpoint.EndpointBuilder::build)
				.toList();
		repositorioEndpoint.saveAll(endpoints);
	}

	public void agregarRegiones() {
		var regiones = Stream.of(
						Region.builder().idRegion("R1").nombre("Región 1"),
						Region.builder().idRegion("R2").nombre("Región 2"),
						Region.builder().idRegion("OC").nombre("Oficinas Centrales")
				)
				.map(Region.RegionBuilder::build)
				.toList();
		repositorioRegion.saveAll(regiones);
	}

	public void agregarEstados() {
		var r1 = Region.builder().idRegion("R1").nombre("Región 1").build();
		var r2 = Region.builder().idRegion("R2").nombre("Región 2").build();
		var oc = Region.builder().idRegion("OC").nombre("Oficinas Centrales").build();

		var estados = Stream.of(
				Estado.builder().idEstado("BC").nombre("Baja California").region(r1),
				Estado.builder().idEstado("BCS").nombre("Baja California Sur").region(r1),
				Estado.builder().idEstado("CHIH").nombre("Chihuahua").region(r2),
				Estado.builder().idEstado("CDMX").nombre("Ciudad de México").region(oc),
				Estado.builder().idEstado("COAH").nombre("Coahuila").region(r2),
				Estado.builder().idEstado("DGO").nombre("Durango").region(r2),
				Estado.builder().idEstado("NAY").nombre("Nayarit").region(r1),
				Estado.builder().idEstado("NL").nombre("Nuevo León").region(r2),
				Estado.builder().idEstado("SIN").nombre("Sinaloa").region(r1),
				Estado.builder().idEstado("SON").nombre("Sonora").region(r1),
				Estado.builder().idEstado("ZAC").nombre("Zacatecas").region(r2),
				Estado.builder().idEstado("REG").nombre("Región Lagunera").region(r2)
			)
				.map(Estado.EstadoBuilder::build)
				.toList();
		repositorioEstado.saveAll(estados);
	}

	public void agregarDirecciones() {

		var r1 = Region.builder().idRegion("R1").nombre("Región 1").build();
		var r2 = Region.builder().idRegion("R2").nombre("Región 2").build();
		var oc = Region.builder().idRegion("OC").nombre("Oficinas Centrales").build();

		var cdmx = Estado.builder().idEstado("CDMX").nombre("Ciudad de México").build();
		var zac = Estado.builder().idEstado("ZAC").nombre("Zacatecas").build();
		var sin = Estado.builder().idEstado("SIN").nombre("Sinaloa").build();

		var direcciones = Stream.of(
				Direccion.builder().idDireccion("DGEC").nombre("Dirección General de Enlace y Coordinación").estado(cdmx).region(oc),
				Direccion.builder().idDireccion("R1").nombre("Región 1 Noroeste").estado(sin).region(r1),
				Direccion.builder().idDireccion("R2").nombre("Región 2 Noreste").estado(zac).region(r2)
			)
				.map(Direccion.DireccionBuilder::build)
				.toList();
		repositorioDireccion.saveAll(direcciones);
	}

	public void agregarSubdirecciones() {
		var dgec = Direccion.builder().idDireccion("DGEC").nombre("Dirección General de Enlace y Coordinación").build();
		var r1 = Direccion.builder().idDireccion("R1").nombre("Región 1 Noroeste").build();
		var r2 = Direccion.builder().idDireccion("R2").nombre("Región 2 Noreste").build();

		var cdmx = Estado.builder().idEstado("CDMX").nombre("Ciudad de México").build();
		var zac = Estado.builder().idEstado("ZAC").nombre("Zacatecas").build();
		var sin = Estado.builder().idEstado("SIN").nombre("Sinaloa").build();

		var subdirecciones = Stream.of(
				Subdireccion.builder().idSubdireccion("SUBADMONOC").nombre("Subdirección Administrativa").direccion(dgec).estado(cdmx),
				Subdireccion.builder().idSubdireccion("SUBADMONR1").nombre("Subdirección Administrativa").direccion(r1).estado(sin),
				Subdireccion.builder().idSubdireccion("SUBADMONR2").nombre("Subdirección Administrativa").direccion(r2).estado(zac)
			)
				.map(Subdireccion.SubdireccionBuilder::build)
				.toList();
		repositorioSubdireccion.saveAll(subdirecciones);
	}

	public void agregarEmpleado() {

		var region = Region.builder().idRegion("OC").nombre("Oficinas Centrales").build();
		var estado = Estado.builder().idEstado("CDMX").nombre("Ciudad de México").region(region).build();
		var direccion = Direccion.builder().idDireccion("DGEC").nombre("Dirección General de Enlace y Coordinación").region(region).estado(estado).build();
		var subdireccion = Subdireccion.builder().idSubdireccion("SUBADMONOC").nombre("Subdirección Administrativa").direccion(direccion).estado(estado).build();

		var tipoPlaza = TipoPlaza.builder().idTipoPlaza("INCA").nombre("Personal del Instituto Nacional de Carrera").build();
		var puesto = Puesto.builder().idPuesto("SJD1").nombre("Subjefe de Departamento 1").tipoPlaza(tipoPlaza).salarioBruto(15478.49f).build();
		var roles = Stream.of(
						Rol.builder().idRol("ADMIN").descripcion("Administrador"),
						Rol.builder().idRol("RH1").descripcion("Recursos Humanos Nivel 1")
				)
				.map(Rol.RolBuilder::build)
				.collect(Collectors.toSet());


		var empleado = Empleado.builder()
				.idPersona("GUOM2032024")
				.nombre("Manuel")
				.apellidoPaterno("Guerrero")
				.apellidoMaterno("Ortiz")
				.nombreCompleto("Manuel Guerrero Ortiz")
				.curp("GUOM123456HDFRTR01")
				.rfc("GUOM123456GP9")
				.numeroSeguroSocial("12345678901")
				.fechaNacimiento(LocalDate.of(1980, 10, 17))
				.edad((byte) 44)
				.genero(GeneroEnum.MASCULINO)
				.telefonoPersonal("1234567890")
				.correoElectronicoPersonal("migue@correo.com")
				.estadoCivil(EstadoCivilEnum.SOLTERO)
				.hijos(false)
				.contactoEmergenciaNombre("Juan Martinez Ortega")
				.contactoEmergenciaTelefono("1234567890")
				.domicilio(Domicilio.builder()
						.idPersona("GUOM2032024")
						.calle("Calle 123")
						.codigoPostal("12345")
						.colonia("Colonia 123")
						.municipio("Iztapalapa")
						.ciudad("Ciudad de México")
						.estado("Ciudad de México")
						.build())
				.escolaridades(Stream.of(
								Escolaridad.builder()
										.idPersona("GUOM2032024")
										.nivel(NivelesEscolaridadesEnum.TECNICO)
										.carrera("Técnico en Informática")
										.estadoNivel(EstadosNivelesEscolaridadesEnum.TITULADO)
										.cedulaProfesional("1234567"),
								Escolaridad.builder()
										.idPersona("GUOM2032024")
										.nivel(NivelesEscolaridadesEnum.LICENCIATURA)
										.carrera("Ingeniería en Sistemas Computacionales")
										.estadoNivel(EstadosNivelesEscolaridadesEnum.TRAMITE_TITULACION)
										.cedulaProfesional(null)
				).map(Escolaridad.EscolaridadBuilder::build).toList())
				.idEmpleado("GUOM2032024")
				.activo(true)
				.fechaIngreso(LocalDate.of(2024, 3, 16))
				.fechaBaja(null)
				.correoElectronico("correo@trabajo.com")
				.telefono("1234567890")
				.extensionTelefono("1234")
				.diasVacacionesDisponibles((byte) 12)
				.diasVacacionesTomados((byte) 12)
				.motivoBaja(null)
				.region(region)
				.direccion(direccion)
				.subdireccion(subdireccion)
				.tipoPlaza(tipoPlaza)
				.puesto(puesto)
				.roles(roles)
				.build();
		repositorioEmpleado.save(empleado);
	}
}
