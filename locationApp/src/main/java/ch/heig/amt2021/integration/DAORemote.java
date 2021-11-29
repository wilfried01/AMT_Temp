package ch.heig.amt2021.integration;


public interface DAORemote<T> {
    void add(T t);
    void create();
}
