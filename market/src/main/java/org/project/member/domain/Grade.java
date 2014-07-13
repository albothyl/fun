package org.project.member.domain;

public enum Grade {
	ADMIN(1000, null)
  ,	PLATINUM(6, null)
  , GOLD(5, PLATINUM)
  , SILVER(4, GOLD)
  , BRONZE(3, SILVER)
  , BASIC(2, BRONZE)
  , ASSOCIATE(1, BASIC)
  , CRIME(5000, null);
	
	private final int value;
	private final Grade next; 
	
	Grade(int value, Grade next) {  
		this.value = value;
		this.next = next; 
	}
	
	public int intValue() {
		return value;
	}
	
	public Grade nextGrade() { 
		return this.next;
	}
	
	public static Grade valueOf(int value) {
		switch(value) {
		case 5000: return CRIME;
		case 1:    return ASSOCIATE;
		case 2:    return BASIC;
		case 3:    return BRONZE;	
		case 4:    return SILVER;
		case 5:    return GOLD;
		case 6:    return PLATINUM;
		case 1000: return ADMIN;
		default: throw new AssertionError("Unknown value: " + value);
		}
	}
}
