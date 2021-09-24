package subito.parlato.retroroutepuzzle.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
public class Item {

    private String name;

    public String getName() {
		return name;
	}

	public Item() {
		super();
	}

	public Item(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
