package com.solvd.argwinterlab.navigator.db.model;

public class Bus extends AbstractTransport {
    private String line;

    public Bus() {}

    public Bus(long id) {
        super(id);
    }

    public Bus(long id, String model, int weight, String name) {
        super(id, model, weight, name);
    }

    public Bus(long id, String model, int weight, String name, String line) {
        super(id, model, weight, name);
        this.line = line;
    }

    public Bus(String name){
        setName(name);
    }
  
    @Override
    public String getLine() {
        return line;
    }

    @Override
	  public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", line=" + line +
                '}';
    }
}
