package org.project.member.dto;

public enum Grade {
	ADMIN(8, null)
  ,	PLATINUM(7, null)
  , GOLD(6, PLATINUM)
  , SILVER(5, GOLD)
  , BRONZE(4, SILVER)
  , BASIC(3, BRONZE)
  , ASSOCIATE(2, BASIC)
  , CRIME(1, null);
	
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
		case 1: return CRIME;
		case 2: return ASSOCIATE;
		case 3: return BASIC;
		case 4: return BRONZE;	
		case 5: return SILVER;
		case 6: return GOLD;
		case 7: return PLATINUM;
		case 8: return ADMIN;
		default: throw new AssertionError("Unknown value: " + value);
		}
	}
}
