/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class Mascota {
    
    private String codigo;
    private String nombre;
    private String raza;
    private float altura;
    private String color;
    private int anios;
    private float peso;

    public Mascota(String codigo, String nombre, String raza, float altura, String color, int anios, float peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.altura = altura;
        this.color = color;
        this.anios = anios;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Mascota{" + "codigo=" + codigo + ", nombre=" + nombre + ", raza=" + raza + ", altura=" + altura + ", color=" + color + ", anios=" + anios + ", peso=" + peso + '}';
    }

    
    
    
    
    
    
           
    
    
    
    
}
