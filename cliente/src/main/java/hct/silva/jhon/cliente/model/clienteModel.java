package hct.silva.jhon.cliente.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
public class clienteModel {

    @Id
    private Long id;

    private String dni;

    private String nombres;

    private String apellidos;

    private String celular;

    private String correo;

    private String licencia;

    private String estado = "activo";
}
