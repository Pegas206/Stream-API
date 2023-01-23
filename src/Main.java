import ru.netology.person.Education;
import ru.netology.person.Person;
import ru.netology.person.Sex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //Список людей младше 18
        System.out.println("Список людей младше 18");
        persons.stream().filter((s)-> s.getAge() < 18).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        //Список призывников с 18 по 20 лет
        System.out.println("список призывников");
        persons.stream().filter((s)-> s.getAge() >= 18 && s.getAge() < 27 && s.getSex() == Sex.MAN).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        //Список потенциально работоспособных людей с высшим образованием
        System.out.println("Список потенциально работоспособных людей с высшим образованием");
        persons.stream().filter(((s)-> s.getAge() >= 18 && s.getAge() < 65 && s.getSex() == Sex.MAN || s.getAge() >= 18 && s.getAge() < 60 && s.getSex() == Sex.WOMAN)).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();


    }
    }
