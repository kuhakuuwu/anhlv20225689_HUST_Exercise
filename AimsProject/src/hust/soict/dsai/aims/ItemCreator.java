package aims;

import aims.media.*;

public class ItemCreator {

    public static Media createMedia(String input) {
        String[] parts = input.split("-");
        String mediaType = parts[0].toLowerCase(); // Normalize the media type to lowercase

        try {
            switch (mediaType) {
                case "dvd":
                    // Format: dvd-title-category-director-length-cost
                    String dvdTitle = parts[1];
                    String dvdCategory = parts[2];
                    String dvdDirector = parts[3];
                    int dvdLength = Integer.parseInt(parts[4]);
                    float dvdCost = Float.parseFloat(parts[5]);
                    return new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);

                case "cd":
                    // Format: cd-title-category-director-artist-length-cost
                    String cdTitle = parts[1];
                    String cdCategory = parts[2];
                    String cdDirector = parts[3];
                    String cdArtist = parts[4];
                    int cdLength = Integer.parseInt(parts[5]);
                    float cdCost = Float.parseFloat(parts[6]);
                    return new CompactDisc(cdTitle, cdCategory, cdDirector, cdArtist, cdLength, cdCost);

                case "book":
                    // Format: book-title-category-author
                    String bookTitle = parts[1];
                    String bookCategory = parts[2];
                    String author = parts[3];
                    Book book = new Book(bookTitle, bookCategory, 0.0f); // Default cost to 0.0
                    book.addAuthor(author);
                    return book;

                default:
                    throw new IllegalArgumentException("Invalid media type: " + mediaType);
            }
        } catch (Exception e) {
            System.out.println("Error creating media: " + e.getMessage());
            return null;
        }
    }
}

