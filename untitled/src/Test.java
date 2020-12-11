import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//                List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
//                Stream<Character> stream3 = MstrList.stream()
//                        .flatap(Test::filterCharacter);
//                stream3.forEach(System.out::println);

        List<String> list = Arrays.asList("hello", "world");

        List<Stream<String>> collect = list.stream()
                .map(s -> s.split(""))
                // Arrays::stream 接受一个数组并产生一个 Stream<String>
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String[]> collect1 = list.stream()
                .map(s -> s.split(""))
                // flapMap方法把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
//                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> collect2 = list.stream()
                .map(s -> s.split(""))
                // flapMap方法把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> lista = new ArrayList<>();
        list.stream()
                .map(s -> s.split(""))
                .map(e -> Arrays.stream(e))
                .forEach(e -> {
                    e.forEach(a -> lista.add(a));
                });

        list.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
        list.stream()
                .flatMap(s -> Stream.empty());
    }


    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }
}
