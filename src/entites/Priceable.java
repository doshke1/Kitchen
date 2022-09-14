package entites;

public interface Priceable {

   default Double getPrice(){
       return 0.0;
   };

}
