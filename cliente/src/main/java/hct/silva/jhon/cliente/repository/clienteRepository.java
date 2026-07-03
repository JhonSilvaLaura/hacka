package hct.silva.jhon.cliente.repository;

import hct.silva.jhon.cliente.model.clienteModel;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface clienteRepository extends ReactiveCrudRepository<clienteModel, Long> {
}
