package entites;

public interface Weightable {

    default Double getTotalWeight(){
        return 0.0;
    };
}
