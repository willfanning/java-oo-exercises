package blogz;

public class Entity {

	private final int uid;
	
	private static int counter = 0;
	
	public Entity() {
		this.uid = counter;
		counter++;
	}

	public int getUid() {
		return uid;
	}
	
}
