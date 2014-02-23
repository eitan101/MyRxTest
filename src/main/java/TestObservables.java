
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author handasa
 */
public class TestObservables {

    public static void main(String[] args) {
        hello(
                new CrudEvent<>(CRUD.create, new Pm("banana", 1)),
                new CrudEvent<>(CRUD.create, new Pm("tapuz", 2)),
                new CrudEvent<>(CRUD.update, new Pm("banana", 2)));
    }

    public static void hello(CrudEvent<Pm>... names) {
        final HashSet<Pm> set = new HashSet<>();
        Observable.from(names)
                //                .map((Pm p) -> {return new CrudEvent<>(CRUD.create,p);})
                //                .filter((CrudEvent<Pm> e)-> { return e.entity.count>1; })
                .map((CrudEvent<Pm> p) -> {
                    boolean exists = set.contains(p.entity);
                    switch (p.event) {
                        case create:
                            set.add(p.entity);
                            return (exists ? null : p);
                        case update:
                            return (exists ? p : new CrudEvent<Pm>(CRUD.create, p.entity));
                        case delete:
                            set.remove(p.entity);
                            return (exists ? p : null);
                    }
                    return p;
                })
                .filter((CrudEvent<Pm> e) -> {
                    return e != null;
                })
                .subscribe((CrudEvent s) -> {
                    System.out.println("Hello " + s + "!");
                });
    }
}
