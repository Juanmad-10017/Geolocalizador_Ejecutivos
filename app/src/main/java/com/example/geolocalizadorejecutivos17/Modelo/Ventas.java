package com.example.geolocalizadorejecutivos17.Modelo;

public class Ventas {

    String Cantidad, Codigo, MontoTotal, MontoUnitario, Producto;

    public Ventas(String cantidad, String codigo, String montoTotal, String montoUnitario, String producto) {
        Cantidad = cantidad;
        Codigo = codigo;
        MontoTotal = montoTotal;
        MontoUnitario = montoUnitario;
        Producto = producto;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getMontoTotal() {
        return MontoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        MontoTotal = montoTotal;
    }

    public String getMontoUnitario() {
        return MontoUnitario;
    }

    public void setMontoUnitario(String montoUnitario) {
        MontoUnitario = montoUnitario;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
    }
}
