package br.com.fiap.tech.challengeiii.fuiegoxxtei.application.gateways;

public interface GenericCRUDGateway<T> {

    T salvar(T entity);

    T atualizar(T entity);

    boolean deletar(T entity);

    T obterPorId(T entity);
}
