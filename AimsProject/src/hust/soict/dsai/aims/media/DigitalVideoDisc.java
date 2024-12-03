package aims.media;

public class DigitalVideoDisc extends Disc {
    //Đếm số lượng DVD hiện có 
    private static int nbDigitalVideoDisc = 0;


    public static int getNumberOfDVD() {
        return nbDigitalVideoDisc;
    }

    //Construtor
    //All
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
        nbDigitalVideoDisc++;
    }
    
    //By Title
    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDisc++;
    }

    //By category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        nbDigitalVideoDisc++;
    }

    //By title and cost
    public DigitalVideoDisc(String title, float cost) {
        super(title, cost);
        nbDigitalVideoDisc++;
    }

    //By director, category, title and cost	
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
        nbDigitalVideoDisc++;
    }

    //Kiểm tra xem có đúng Title không
    public boolean isMatch(String title){
        return this.getTitle().equalsIgnoreCase(title);
    }
    
    //Hiển thị thông tin DVD
    public void displayInfo() {
        System.out.print("DVD - " + getTitle());

        if (getCategory() != null) {
            System.out.print(" - " + getCategory());
        } else System.out.print(" - N/A" );

        if (getDirector() != null) {
            System.out.print(" - " + getDirector());
        } else System.out.print(" - N/A" );

        if (getLength() !=  0) {
            System.out.print(" - " + getLength() + " mins");
        } else System.out.print(" - N/A" );

        System.out.print(": " + getCost() + "$");

        System.out.println();
    }

}
