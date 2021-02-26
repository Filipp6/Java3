public class Service {

    private Service(){}

    private static volatile Service service;

    public static Service getInstance(){
        if(service == null){
            synchronized (Service.class){
                if(service == null){
                    service = new Service();
                }
            }
        }
        return service;
    }


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
