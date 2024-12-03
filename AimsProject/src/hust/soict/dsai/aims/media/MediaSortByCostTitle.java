package aims.media;

import java.util.Comparator;

public class MediaSortByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // Sort by cost in descending order
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        
        // If costs are the same, sort by title alphabetically
        return m1.getTitle().compareTo(m2.getTitle());
    }
}

