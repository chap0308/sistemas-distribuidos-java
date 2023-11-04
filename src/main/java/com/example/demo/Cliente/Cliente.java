package com.example.demo.Cliente;

import java.util.List;

import com.example.demo.Pedidos.Pedidos;
import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//* Para no usar getter, setter ni constructores, usamos los siguientes 3 decoradores. Esto nos brinda un codigo limpio */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    //* Para actualizar los datos, tenemos que eliminar la tabla y volver a ejecutar */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Basic
    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String email;
    private String telefono;
    @OneToMany(mappedBy = "cliente")
    @JsonBackReference
    private List<Pedidos> pedidos;
}
