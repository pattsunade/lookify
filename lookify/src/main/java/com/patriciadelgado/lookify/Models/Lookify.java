package com.patriciadelgado.lookify.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Lookify")
public class Lookify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 20)
    private String title;

    @Size(min = 5, max = 20)
    private String artista;

    @Min(1) @Max(10)
    private Integer calificacion;

    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date upDateAt;

    public Lookify() {

    }

    public Lookify(String title, String artista, Integer calificacion) {
        this.title = title;
        this.artista = artista;
        this.calificacion = calificacion;

    }
    // Otros getters y setters fueron removidos para resumir

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpDateAt() {
        return upDateAt;
    }

    public void setUpDateAt(Date upDateAt) {
        this.upDateAt = upDateAt;
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.upDateAt = new Date();
}
   
}
