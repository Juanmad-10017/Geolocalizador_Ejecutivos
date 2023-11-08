package com.example.geolocalizadorejecutivos17.Modelo;

public class Clientes {
    String Correo,Direccion_Empresa,Nombre_Contacto,Nombre_Empresa,Telefono_contacto;

    public Clientes(String correo, String direccion_Empresa, String nombre_Contacto, String nombre_Empresa, String telefono_contacto) {
        Correo = correo;
        Direccion_Empresa = direccion_Empresa;
        Nombre_Contacto = nombre_Contacto;
        Nombre_Empresa = nombre_Empresa;
        Telefono_contacto = telefono_contacto;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion_Empresa() {
        return Direccion_Empresa;
    }

    public void setDireccion_Empresa(String direccion_Empresa) {
        Direccion_Empresa = direccion_Empresa;
    }

    public String getNombre_Contacto() {
        return Nombre_Contacto;
    }

    public void setNombre_Contacto(String nombre_Contacto) {
        Nombre_Contacto = nombre_Contacto;
    }

    public String getNombre_Empresa() {
        return Nombre_Empresa;
    }

    public void setNombre_Empresa(String nombre_Empresa) {
        Nombre_Empresa = nombre_Empresa;
    }

    public String getTelefono_contacto() {
        return Telefono_contacto;
    }

    public void setTelefono_contacto(String telefono_contacto) {
        Telefono_contacto = telefono_contacto;
    }

    public Clientes (){

    }
}
