/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author handasa
 */
public class Pm {
    public String name;
    public int count;

    public Pm(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pm{" + "name=" + name + ", count=" + count + '}';
    }
    
}
