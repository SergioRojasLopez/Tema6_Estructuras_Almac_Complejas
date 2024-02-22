import java.util.*;

public class Equipo {

	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {

		
	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {

		
	}

	/**
	 * Devuelve una cadena con el listado de los Alumnos
	 * 
	 * @return Cadena con el listado de Alumnos
	 */
	public String listadoDeAlumnos() {

        return null;
    }
	

	
	public Alumno buscarAlumno(Alumno alumnoBuscado){


        return alumnoBuscado;
    }

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro
	 *            Otro equipo que se va a unir
	 * @param nombre
	 *            Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) {


        return otro;
    }

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this
	 * y otro)
	 * 
	 * @param otro
	 *            Otro equipo
	 * @param nombre
	 *            Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) {

        return otro;
    }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Equipo{");
		sb.append("nombreEquipo='").append(nombreEquipo).append('\'');
		sb.append(", conjuntoAlumnos=").append(conjuntoAlumnos);
		sb.append('}');
		return sb.toString();
	}
}
