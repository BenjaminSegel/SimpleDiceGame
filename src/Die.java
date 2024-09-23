import java.util.Random;

public class Die {
    private int currentValue;
    private int maxValue;
    static Random r = new Random();
    public Die(int maxValue){
        this.maxValue = maxValue;
        this.currentValue = 0;
    }

    public int getMaxValue(){
        return maxValue;
    }

    public void roll(){
        currentValue = r.nextInt(maxValue) + 1;
        System.out.println(currentValue);
    }

    public int getCurrentValue(){
        return currentValue;
    }


}
