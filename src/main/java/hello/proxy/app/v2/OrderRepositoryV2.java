package hello.proxy.app.v2;

public class OrderRepositoryV2 {

    public void save(String itemId) {

        // 저장로직
        if(itemId.equals ("ex")){
            throw new IllegalStateException();
        }

        sleep(1000);

    }

    private void sleep(int mills) {
        try{
            Thread.sleep(mills);
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
