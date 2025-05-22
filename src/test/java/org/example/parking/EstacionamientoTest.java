package org.example.parking;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.Assert.*;
import static org.example.parking.Vehiculo.Tipo.AUTO;
import static org.example.parking.Vehiculo.Tipo.SUV;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //TOD test
        Estacionamiento parking = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", AUTO);
        String dni = "43693160";
        String nombre = "Raven";

        boolean ingresoExitoso = parking.ingresarVehiculo(dni, nombre, vehiculo);
        assertTrue("El ingreso del vehiculo fue exitoso", ingresoExitoso);

        Ticket ticket = parking.retirarVehiculo("ABC123");
        assertNotNull("El ticket no debería ser nulo", ticket);
        assertEquals("La patente debería coincidir", "ABC123", ticket.getVehiculo().getPatente());
        assertNotNull("La hora de salida no debería ser nula", ticket.getHoraSalida());
        assertTrue("La duracion debe ser mayor a 0", ticket.calcularMinutos() > 0);
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        // TOD test
        Cliente cliente = new Cliente ("43693160", "Raven");
        Vehiculo auto = new Vehiculo("ABC123", "Toyota", SUV);
        Ticket ticket = new Ticket(cliente, auto);
        LocalDateTime entrada = LocalDateTime.now().minusMinutes(80);
        ticket.setHoraSalida(LocalDateTime.now().plusMinutes(80));

        long minutos = ticket.calcularMinutos();
        assertTrue("Debe calcular al menos 80 minutos", minutos >= 80);

        double precio = ticket.calcularPrecio();
        assertEquals("SUV debe pagar 130 por hora, 80 min redondea a 2 horas", 260.0, precio);
    }

}