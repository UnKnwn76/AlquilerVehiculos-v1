/*************************************************
	 Ismail Hilmi
	 1ºDAW
	 Tarea online 05
*************************************************/
package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes {

	/*************************************************
	 * ATRIBUTOS Y CONSTANTES
	 *************************************************/
	private List<Cliente> coleccioneCliente;

	/**************************************************
	 * CONSTRUCTORES
	 **************************************************/
	public Clientes() {
		coleccioneCliente = new ArrayList<>();
	}

	/**************************************************
	 * METODOS
	 **************************************************/
	@Override
	public List<Cliente> get() {
		return new ArrayList<>(coleccioneCliente);
	}

	@Override
	public int getCantidad() {
		return coleccioneCliente.size();
	}

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}

		coleccioneCliente.add(cliente);
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		int indice = coleccioneCliente.indexOf(cliente);
		return indice == -1 ? null : coleccioneCliente.get(indice);
	}

	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccioneCliente.remove(cliente);
	}

	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			if (nombre != null && !nombre.isBlank()) {
				cliente.setNombre(nombre);
			}
			if (telefono != null && !telefono.isBlank()) {
				cliente.setTelefono(telefono);
			}
		}

	}

}
