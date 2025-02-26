package com.entregable.ClienteApiRest.service;

import java.util.List;
//interface para definir operaciones en el service
public interface ClienteServiceI<T, K> {
    K crearCliente(T cliente);
    K obtenerById(Long idCliente);
    List<K> obtenerTodos();
    void eliminarTodos();

}
