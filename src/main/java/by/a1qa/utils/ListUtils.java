package by.a1qa.utils;

import by.a1qa.models.Show;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    private static List<Show> sortByPrice(List<Show> shows) {
        return shows.stream()
                .sorted(Comparator.comparingDouble(Show :: getPrice))
                .collect(Collectors.toList());
    }

    public static List<Show> getSortedShowList(List<Show> shows) {
        return sortByPrice(shows);
    }
}
