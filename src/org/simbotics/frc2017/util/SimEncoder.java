package org.simbotics.frc2017.util;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Mike
 */
public class SimEncoder extends Encoder{
	private int prev;
	private int speed;
    private int offset;
    
  
    
    public SimEncoder(int aChannel, int bChannel, boolean reverseDirection,
            CounterBase.EncodingType encodingType, int preset) {
        super(aChannel, bChannel, reverseDirection, encodingType);
        this.offset = preset;
        this.setDistancePerPulse(1);
    }
    
    public SimEncoder(int aChannel, int bChannel, boolean reverseDirection,
            CounterBase.EncodingType encodingType) {
        this(aChannel, bChannel, reverseDirection, encodingType, 0);
    }
    
    public SimEncoder(int aChannel, int bChannel, boolean reverseDirection,
            int preset) {
        this(aChannel, bChannel, reverseDirection,
                CounterBase.EncodingType.k4X, preset);
    }
    
    public SimEncoder(int aChannel, int bChannel, boolean reverseDirection) {
        this(aChannel, bChannel, reverseDirection,
                CounterBase.EncodingType.k4X, 0);
    }
    
    public SimEncoder(int aChannel, int bChannel, int preset) {
        this(aChannel, bChannel, false, CounterBase.EncodingType.k4X, preset);
    }
    
    public SimEncoder(int aChannel, int bChannel) {
        this(aChannel, bChannel, false, CounterBase.EncodingType.k4X, 0);
    }
    
    @Override
	public int get() {
        return super.get() + this.offset;
    }
    
    @Override
	public void reset() {
        super.reset();
        this.offset = 0;
        this.prev = 0;
    }
    
    public void set(int val) {
        super.reset();
        this.offset = val;
    }
    
    public int speed(){
    	return this.speed;
    }
    
    public void updateSpeed(){
    	int curr = this.get();
    	this.speed = curr - this.prev;
    	this.prev = curr;
    }
    
    public double rawSpeed(){
    	return this.getRate();
    }
        
}
