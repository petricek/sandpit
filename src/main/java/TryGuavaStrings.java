import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by petricek on 4/29/14.
 */
public class TryGuavaStrings {

    static final String str = Joiner.on(",").join(Arrays.asList(1, 5, 7));

    public static void main(String args[]) {

        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
        System.out.println(Joiner.on(",").join(Arrays.asList(1, 5, 7)));

        System.out.println(str);

        List<String> list = Lists.newArrayList(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(",,,323,,23,23,32,,,,"));

        System.out.println(CharMatcher.(Pattern.compile("\r?\n")).replaceFrom("yaha", "oo"));

    }
}
