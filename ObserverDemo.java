import java.util.Observer;
import java.util.Observable;
public class ObserverDemo {
    public static void main(String[] args) {
        stock AMZM = new stock();
        Observer trader1 = new trader1(); 
        Observer trader2 = new trader2(); 
        AMZM.addObserver(trader1);
        AMZM.addObserver(trader2);
		float x = (float)(0.01 * Math.round((Math.random()*100)) + Math.round((Math.random()*10)) - 5);
        AMZM.setPrice(x);
    }
}

class stock extends Observable {
    private float price;
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        super.setChanged();  
        super.notifyObservers(price);    
        this.price = price;
    }
}

class trader1 implements Observer {
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
		System.out.println("**********Trader1's action**********");
        if (price > 0) {
            System.out.println("AMZN goes up $" + price + " What a happy day!");
        } else {
            System.out.println("AMZN goes down $" + (-price) + " What a sad day!");
        }
		System.out.println();
    }
}

class trader2 implements Observer {
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
		System.out.println("**********Trader2's action**********");
        if (price > 0) {
            System.out.println("AMZN goes up $" + price + " None of my business.");
        } else {
            System.out.println("AMZN goes down $" + (-price) + " I should buy some!");
        }
		System.out.println();
    }
}
