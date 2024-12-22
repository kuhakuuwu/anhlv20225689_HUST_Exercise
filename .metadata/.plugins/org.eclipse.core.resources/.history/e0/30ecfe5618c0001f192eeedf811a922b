package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaSortByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparision = m1.getTitle().compareTo(m2.getTitle());
        if (titleComparision != 0) {
            return titleComparision;
        }

        return Float.compare(m2.getCost(), m1.getCost());
    }

}


