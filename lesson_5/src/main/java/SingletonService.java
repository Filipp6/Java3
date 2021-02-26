public enum SingletonService {

    SERVICE;

    public void sendMail(){
        System.out.println("Sending mail");
    }

    public void prepareData(){
        System.out.println("Preparing data");
    }

    public void getInfo(){
        System.out.println("Getting info");
    }
}
