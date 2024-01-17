package ca.bytetube.day19_mutiThread.practice;

public class Input implements Runnable{
    private Resource resource;

    public Input(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int count = 0;
        int end = 5;
        while (true){
            if (count == end) break;
            if (count % 2 == 0) resource.setResource("fang", "female");
            else resource.setResource("sheng", "male");
            count++;
        }

    }
}
