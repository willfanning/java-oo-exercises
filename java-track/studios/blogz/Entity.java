package blogz;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// reference
		if (this == obj) return true;
		// null
		if (obj == null) return false;
		// type
		if (!(obj instanceof Entity)) return false;
		// cast to Entity
		Entity e = (Entity) obj;
		return Objects.equals(uid, e.uid);
	}
	
	
	
}
