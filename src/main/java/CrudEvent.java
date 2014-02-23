/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author handasa
 */
public class CrudEvent<T> {
    final CRUD event;
    final T entity;

    public CrudEvent(CRUD event, T entity) {
        this.event = event;
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "CrudEvent{" + "event=" + event + ", entity=" + entity + '}';
    }
    
}
