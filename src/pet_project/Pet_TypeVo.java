package pet_project;

public class Pet_TypeVo {

	private long TypeNo;
	private String Type;

	public Pet_TypeVo() {

	}

	public Pet_TypeVo(long TypeNo, String Type) {
		super();
		this.TypeNo = TypeNo;
		this.Type = Type;
	}

	public long getTypeNo() {
		return TypeNo;
	}

	public void setTypeNo(long typeNo) {
		TypeNo = typeNo;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@Override
	public String toString() {
		return TypeNo + ". " + Type;
	}
}
