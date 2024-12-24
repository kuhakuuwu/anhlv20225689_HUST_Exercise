package hust.soict.dsai.aims.media;

public class TestPassingParameter {
    public static void main(String[] args) {
        //TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
 
        Wrapper<DigitalVideoDisc> jungleWrapper = new Wrapper<>(jungleDVD);
        Wrapper<DigitalVideoDisc> cinderellaWrapper = new Wrapper<>(cinderellaDVD);
 
        swap(jungleWrapper, cinderellaWrapper);
 
        jungleDVD = jungleWrapper.value;
        cinderellaDVD = cinderellaWrapper.value;
 
        System.out.println("After swap:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
 
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After change title: ");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
   
    //Old swap
    /*
    public static void swap (Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    */  
 
    //New swap
    public static class Wrapper<T> {
        public T value;
   
        public Wrapper(T value) {
            this.value = value;
        }
    }  
 
    public static <T> void swap(Wrapper<T> o1, Wrapper<T> o2) {
        T temp = o1.value;
        o1.value = o2.value;
        o2.value = temp;
    }
   
 
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}