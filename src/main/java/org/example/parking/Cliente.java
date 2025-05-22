package org.example.parking;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private final String dni;
    private final String nombre;
    private final List<Vehiculo> vehiculos;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        // TOD implementar la carga de vehiculos en el cliente
        if (vehiculo != null) {
            vehiculos.add(vehiculo);
        }
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        // TOD implementar la busqueda de un vehiculo segun su patente
        if(patente == null || patente.isBlank()) {
            return null;
        }
        for (Vehiculo v : vehiculos) {
            if (patente.equalsIgnoreCase(v.getPatente())){
                return v;
            }
        }
        return null;
    }
}