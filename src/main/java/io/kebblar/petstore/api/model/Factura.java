package io.kebblar.petstore.api.model;

import java.util.Date;
import java.util.Objects;

public class Factura {

    private int id;
    private Date fecha;
    private String clienteRfc;
    private int idProducto;
    private double precio;
    private int iva;

    public Factura() {
    }

    public Factura(int id, Date fecha, String clienteRfc, int idProducto, double precio, int iva) {
        this.id = id;
        this.fecha = fecha;
        this.clienteRfc = clienteRfc;
        this.idProducto = idProducto;
        this.precio = precio;
        this.iva = iva;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getClienteRfc() {
        return clienteRfc;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIva() {
        return iva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setClienteRfc(String clienteRfc) {
        this.clienteRfc = clienteRfc;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", clienteRfc='" + clienteRfc + '\'' +
                ", idProducto=" + idProducto +
                ", precio=" + precio +
                ", iva=" + iva +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;
        Factura factura = (Factura) o;
        return id == factura.id && idProducto == factura.idProducto && Double.compare(factura.precio, precio) == 0 && iva == factura.iva && Objects.equals(fecha, factura.fecha) && Objects.equals(clienteRfc, factura.clienteRfc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, clienteRfc, idProducto, precio, iva);
    }
}
