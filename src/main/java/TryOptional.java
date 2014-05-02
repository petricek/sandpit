import com.google.common.base.Optional;

/**
 * Created by petricek on 5/1/14.
 */
public class TryOptional {
    public static void main(String args[]){
        Optional<Integer> number = Optional.fromNullable(null);
        if(number.isPresent()){
            System.out.println("PRESENT");
        }
        else
        {
            System.out.println("ABSENT");
        }
        System.out.println(number.get()+1);

    }
}
