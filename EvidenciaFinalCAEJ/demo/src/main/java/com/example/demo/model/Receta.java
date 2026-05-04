package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    @Column(length = 1500)
    private String ingredientes;

    @Column(length = 3500)
    private String instrucciones;

    public Receta() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }
    public String getInstrucciones() { return instrucciones; }
    public void setInstrucciones(String instrucciones) { this.instrucciones = instrucciones; }
}