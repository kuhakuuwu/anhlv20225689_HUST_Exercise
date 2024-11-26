package aims.disc;

public class DigitalVideoDisc {
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    //Đếm số lượng DVD hiện có 
    private static int nbDigitalVideoDisc = 0;

    //Accessor (Getter)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    //Setter
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    //Construtor
    //All
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        //Gán ID và cập nhập biến đếm nbDigitalVideoDisc
        this.id = ++nbDigitalVideoDisc;
    }
    
    //By Title
    public DigitalVideoDisc(String title) {
        this.title = title;

        //Gán ID và cập nhập biến đếm nbDigitalVideoDisc
        this.id = ++nbDigitalVideoDisc;
    }

    //By category, title and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;

        //Gán ID và cập nhập biến đếm nbDigitalVideoDisc
        this.id = ++nbDigitalVideoDisc;
    }

    //By director, category, title and cost	
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;

        //Gán ID và cập nhập biến đếm nbDigitalVideoDisc
        this.id = ++nbDigitalVideoDisc;
    }

    //Kiểm tra xem có đúng Title không
    public boolean isMatch(String title){
        return this.title.equalsIgnoreCase(title);
    }
    
    //Hiển thị thông tin DVD
    public void displayInfo() {
        System.out.print("DVD -");
        System.out.print(" " + title);
        if (category != null) {
            System.out.print(" - " + category);
        } else System.out.print(" - Not Found" );
        if (director != null) {
            System.out.print(" - " + director);
        } else System.out.print(" - Not Found" );
        if (length !=  0) {
            System.out.print(" - " + length + " mins");
        } else System.out.print(" - Not Found" );
        System.out.print(": " + cost + "$");
        System.out.println();
    }

}
