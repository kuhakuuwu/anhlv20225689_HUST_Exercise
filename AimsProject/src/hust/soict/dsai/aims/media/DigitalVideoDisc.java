package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD - ").append(getTitle());

        if (getCategory() != null) {
            sb.append(" - ").append(getCategory());
        } else {
            sb.append(" - N/A");
        }

        if (getDirector() != null) {
            sb.append(" - ").append(getDirector());
        } else {
            sb.append(" - N/A");
        }

        if (getLength() != 0) {
            sb.append(" - ").append(getLength()).append(" mins");
        } else {
            sb.append(" - N/A");
        }

        sb.append(": ").append(getCost()).append("$\n");

        return sb.toString();
    }

    @Override
    public String play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            return "Playing " + this.getTitle() + " - " + this.getLength() + " mins";
        } else {
        	System.out.println("DVD \"" + this.getTitle() + "\" cannot be played!");
        	return this.getTitle() + "cannot be played!";
        }
        
    }

}

