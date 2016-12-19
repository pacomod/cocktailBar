package fr.formation.entity;

import java.util.EnumSet;

public enum State {
	Liquid(0),
	Solid(1),
	Gaz(2),
	NONE(-1);

	private int value;
	
	State(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
	
	public static State getEnum(int value) {
		switch (value) {
		case 0:
			return State.Liquid;
		case 1:
			return State.Solid;
		case 2:
			return State.Gaz;
			default:
				return State.NONE;
		}
	}
	
	public static final EnumSet<State> all = EnumSet.of(Liquid, Solid, Gaz);
}
