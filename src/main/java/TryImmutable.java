import com.google.common.collect.ImmutableSet;

/**
 * Created by petricek on 5/1/14.
 */
public class TryImmutable {
    public static void main(String args[]){
        System.out.println(COLOR_NAMES.size());
//        COLOR_NAMES.add("hey");
    }
    private static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");


};


